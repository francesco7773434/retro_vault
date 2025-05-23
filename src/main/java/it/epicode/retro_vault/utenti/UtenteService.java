package it.epicode.retro_vault.utenti;


import it.epicode.retro_vault.auth.JwtTokenUtil;
import it.epicode.retro_vault.auth.Role;
import it.epicode.retro_vault.cloudinary.CloudinaryService;
import it.epicode.retro_vault.common.CommonResponse;
import it.epicode.retro_vault.common.EmailSenderService;
import it.epicode.retro_vault.exceptions.NotFoundException;
import it.epicode.retro_vault.exceptions.UsernameException;
import jakarta.mail.MessagingException;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Validated
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;
   @Autowired
    private CloudinaryService cloudinaryService;
   @Autowired
    private EmailSenderService emailSenderService;
   @Autowired
    private PasswordEncoder passwordEncoder;
   @Autowired
    private AuthenticationManager authenticationManager;
   @Autowired
    private JwtTokenUtil jwtTokenUtil;


   //REGISTRAZIONE UTENTE

    public Utente registerUtente(UtenteAuthRequest request) throws MessagingException {
        if (utenteRepository.existsByUsername(request.getUsername())) {
            throw new EntityExistsException("Username già in uso");
        }

        Utente utente = new Utente();
        utente.setNome(request.getNome());
        utente.setCognome(request.getCognome());
        utente.setEmail(request.getEmail());
        utente.setUsername(request.getUsername());
        utente.setPassword(passwordEncoder.encode(request.getPassword()));
        utente.setRoles(Set.of(Role.ROLE_USER));
        utente.setAvatar("https://ui-avatars.com/api/?name=" + utente.getNome() + "+" + utente.getCognome());
        emailSenderService.sendEmail(utente.getEmail(), "Benvenuto", "Ciao "+utente.getNome() + " " + utente.getCognome()+"! Benvenuto nella nostra azienda!" );
        return utenteRepository.save(utente);
    }

    public Optional<Utente> findByUsername(String username) {
        return utenteRepository.findByUsername(username);
    }

    //LOGIN UTENTE

    public String authenticateUser(String username, String password)  {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            Utente utente= (Utente) authentication.getPrincipal();
            return jwtTokenUtil.generateToken(utente);
        } catch (AuthenticationException e) {
            throw new SecurityException("Credenziali non valide", e);
        }
    }
    public CommonResponse createUtente(UtenteRequest request) throws MessagingException {
        Utente utente= new Utente();
        BeanUtils.copyProperties(request, utente);
        if (utenteRepository.existsByUsername(utente.getUsername())) {
            throw new UsernameException("Username già in uso");
        }
        if (utenteRepository.existsByEmail(utente.getEmail())) {
            throw new UsernameException("Email già in uso");
        }
        utente.setAvatar("https://ui-avatars.com/api/?name=" + utente.getNome() + "+" + utente.getCognome());
        utente = utenteRepository.save(utente);
        emailSenderService.sendEmail(utente.getEmail(), "Benvenuto", "Ciao "+utente.getNome() + " " + utente.getCognome()+"! Benvenuto nella nostra azienda!" );
        return new CommonResponse(utente.getId());
    }

    public List<UtenteResponse> getAllUtenti() {
        return utenteRepository.findAll().stream()
                .map(UtenteResponse::new)
                .collect(Collectors.toList());
    }

    public Utente getUtenteById(Long id) {return utenteRepository.findById(id).orElseThrow(() -> new RuntimeException("Utente non trovato"));   }

    public Utente updateUtente(Long id, UtenteRequest request, Utente utenteCorrente) {
        boolean isAdmin = utenteCorrente.getRoles().contains(Role.ROLE_ADMIN);

        // Confronto corretto con .equals() tra Long
        if (utenteCorrente.getId().equals(id) || isAdmin) {
            Utente utente = utenteRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException("Utente non trovato"));

            // Copia solo i campi modificabili
            utente.setNome(request.getNome());
            utente.setCognome(request.getCognome());
            utente.setEmail(request.getEmail());
            utente.setUsername(request.getUsername());
            utente.setAvatar(request.getAvatar());

            return utenteRepository.save(utente);
        } else {
            throw new IllegalArgumentException("Non sei autorizzato a modificare questo utente");
        }
    }

    public void deleteUtente(Long id) {
        if (!utenteRepository.existsById(id)) {
            throw new NotFoundException("Utente non trovato");
        }
        utenteRepository.deleteById(id);
    }

    public boolean existsByUsername(String username) {
        return utenteRepository.existsByUsername(username);
    }

    public void uploadImage(Long id, MultipartFile file) {
        Utente utente= utenteRepository.findById(id).orElseThrow(() -> new NotFoundException("Utente non trovato"));
        utente.setAvatar(cloudinaryService.uploadImage(file));
        utenteRepository.save(utente);
    }

    public UtenteResponse fromEntityToResponse(Utente utente) {
        UtenteResponse utenteResponse = new UtenteResponse();
        BeanUtils.copyProperties(utente, utenteResponse);
        return utenteResponse;
    }




}
