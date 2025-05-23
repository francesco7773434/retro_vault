package it.epicode.retro_vault.utenti;


import com.cloudinary.Cloudinary;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import it.epicode.retro_vault.auth.AuthResponse;
import it.epicode.retro_vault.auth.LoginRequest;
import it.epicode.retro_vault.common.EmailSenderService;
import it.epicode.retro_vault.exceptions.NotFoundException;
import jakarta.mail.MessagingException;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/utenti")
public class UtenteController {
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private EmailSenderService emailSenderService;
    @Autowired
    private Cloudinary cloudinary;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)

    public List<UtenteResponse> getAllUtenti() {return utenteService.getAllUtenti();}

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)

    public Utente findById(@PathVariable Long id) {
        return utenteService.getUtenteById(id);
    }



    @GetMapping("/me")

    public Utente getCurrentUser(@AuthenticationPrincipal Utente utente) {
        return utente;
    }


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createUtente(@RequestBody UtenteAuthRequest request) throws MessagingException {
        utenteService.registerUtente(request);
        return ResponseEntity.ok("Registrazione avvenuta con successo");
    }


    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)

    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        log.info("Login request:");
        String token = utenteService.authenticateUser(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        );
        return ResponseEntity.ok(new AuthResponse(token));
    }


    @PreAuthorize("isAuthenticated()")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Utente updateUtente(
            @PathVariable Long id,
            @RequestBody UtenteRequest request,
            @AuthenticationPrincipal Utente utenteAutenticato) {

        log.info("ID utente autenticato: {}", utenteAutenticato.getId());
        log.info("ID utente da aggiornare: {}", id);

        return utenteService.updateUtente(id, request, utenteAutenticato);
    }
    //aggiunte
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUtente(@PathVariable Long id) {
        utenteService.deleteUtente(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/exists/{username}")
    @ResponseStatus(HttpStatus.OK)
    public void existsByUsername(@PathVariable String username) {
        utenteService.existsByUsername(username);
    }



    @PostMapping("/utenti/{id}/avatar")
    public ResponseEntity<Utente> uploadImage(
            @PathVariable Long id,
            @ModelAttribute AvatarUploadRequest request
    ) {
        utenteService.uploadImage(id, request.getFile());
        return ResponseEntity.ok(utenteService.getUtenteById(id));
    }

    @PostMapping(path = "/{id}/avatars", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public UtenteResponse uploadAvatar(@RequestPart("file") MultipartFile file , @PathVariable Long id) {
        try {
            Map result = cloudinary.uploader()
                    .upload(file.getBytes(), Cloudinary.asMap("folder", "epicode", "public_id",file.getOriginalFilename()));

            String url = result .get("secure_url").toString();
            Utente utente= utenteRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Autore non trovato con id " + id));

            // 3. Aggiorna avatar e salva
            utente.setAvatar(url);
            utenteRepository.save(utente);

            emailSenderService.sendEmail("f14955496@gmail.com", "Immagine caricata con Cloudinary", "<h3>Immagine salvata</h3> <p>URL:<img src='" + url + "'/>  </p>");

            System.out.println(url);

            return utenteService.fromEntityToResponse(utente);

        } catch (IOException e) {
            throw new RuntimeException("Errore durante il caricamento dell'immagine su Cloudinary", e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
