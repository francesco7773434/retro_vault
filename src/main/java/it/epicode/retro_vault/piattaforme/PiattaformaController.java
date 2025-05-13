package it.epicode.retro_vault.piattaforme;

import it.epicode.retro_vault.common.CommonResponse;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/piattaforme")
public class PiattaformaController {
    @Autowired
    private PiattaformaService piattaformaService;
    @GetMapping("/all")
    public List<PiattaformaResponse> getAllPiattaforme() {
        return piattaformaService.getAllPiattaforme();
    }

    @GetMapping("/{id}")
    public PiattaformaResponse getPiattaformaById(@PathVariable Long id) {
        return piattaformaService.getPiattaformaById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommonResponse createPiattaforma(@org.springframework.web.bind.annotation.RequestBody PiattaformaRequest request) {
        return piattaformaService.createPiattaforma(request);
    }

    @PutMapping("/{id}")
    public PiattaformaRequest updatePiattaforma(@PathVariable Long id, @RequestBody PiattaformaRequest request) {
        return piattaformaService.updatePiattaforma(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePiattaforma(@PathVariable Long id) {
        piattaformaService.deletePiattaforma(id);
    }
}
