package it.epicode.retro_vault.recensioni;

import it.epicode.retro_vault.common.CommonResponse;
import it.epicode.retro_vault.exceptions.NotFoundException;
import it.epicode.retro_vault.utenti.Utente;
import it.epicode.retro_vault.utenti.UtenteRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RestController
@RequestMapping("/recensioni")
public class RecensioneController {
    @Autowired
    private RecensioneService recensioneService;
    @Autowired
    private UtenteRepository utenteRepository;


    @GetMapping("/recensioni")
    public Page<RecensioneResponse> getAllRecensioni(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return recensioneService.getAllRecensioni(page, size);
    }

    @GetMapping("/giochi/{giocoId}/recensioni")
    public Page<RecensioneResponse> getRecensioniByGioco(
            @PathVariable Long giocoId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return recensioneService.getRecensioniByGioco(giocoId, page, size);
    }

    @GetMapping("/{id}")
    public RecensioneResponse getRecensioneById(@PathVariable Long id) {
        return recensioneService.getRecensioneById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("isAuthenticated()")
    public CommonResponse createRecensione(@RequestBody RecensioneRequest request, Authentication authentication) {
        String username = authentication.getName();
        Utente utente = utenteRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("Utente non trovato"));

        return recensioneService.createRecensione(request, utente);
    }

    @PutMapping("/{id}")
    public RecensioneRequest updateRecensione(@PathVariable Long id, @RequestBody RecensioneRequest request) {
        return recensioneService.updateRecensione(id, request);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecensione(@PathVariable Long id) {
        recensioneService.deleteRecensione(id);
    }


}
