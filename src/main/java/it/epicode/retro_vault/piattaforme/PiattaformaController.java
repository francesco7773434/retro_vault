package it.epicode.retro_vault.piattaforme;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
