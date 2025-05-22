package it.epicode.retro_vault.utenti;


import it.epicode.retro_vault.auth.AuthResponse;
import it.epicode.retro_vault.auth.LoginRequest;
import it.epicode.retro_vault.exceptions.NotFoundException;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/utenti")
public class UtenteController {
    @Autowired
    private UtenteService utenteService;

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
}
