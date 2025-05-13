package it.epicode.retro_vault.recensioni;

import it.epicode.retro_vault.common.CommonResponse;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RestController
@RequestMapping("/recensioni")
public class RecensioneController {
    @Autowired
    private RecensioneService recensioneService;


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
    public CommonResponse createRecensione(@RequestBody RecensioneRequest request) {
        return recensioneService.createRecensione(request);
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
