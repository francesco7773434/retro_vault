package it.epicode.retro_vault.giochi;

import it.epicode.retro_vault.common.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/giochi")
public class GiocoController {
    @Autowired
    private GiocoService giocoService;


    @GetMapping("/all")
    public ResponseEntity<Page<GiocoResponse>> getAllGiochi( @RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "30") int size,
                                                             @RequestParam(defaultValue = "titolo") String sort) {
        Page<GiocoResponse> giochi = giocoService.getAllGiochi(page, size, sort);
        return ResponseEntity.ok(giochi);
    }
    @GetMapping("/{id}")
    public ResponseEntity<GiocoDettaglioResponse> getGiocoById(@PathVariable Long id) {
        GiocoDettaglioResponse giocoDettaglio = giocoService.getById(id);
        return ResponseEntity.ok(giocoDettaglio);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public CommonResponse createGioco(@RequestBody GiocoRequest request) {
        return giocoService.createGioco(request);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<GiocoRequest> updateGioco(@PathVariable Long id, @RequestBody GiocoRequest request) {
        GiocoRequest updated = giocoService.updateGioco(id, request);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteGioco(@PathVariable Long id) {
        giocoService.deleteGioco(id);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<GiocoResponse>> searchGiochi(
            @RequestParam(required = false) String titolo,
            @RequestParam(required = false) Integer annoUscita,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "30") int size,
            @RequestParam(defaultValue = "titolo") String sort) {

        Page<GiocoResponse> risultati = giocoService.searchGiochi(titolo, annoUscita, page, size, sort);
        return ResponseEntity.ok(risultati);
    }
}
