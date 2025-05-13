package it.epicode.retro_vault.piattaforme;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PiattaformaService {
    private final PiattaformaRepository piattaformaRepository;

    public List<PiattaformaResponse> getAllPiattaforme() {
        return piattaformaRepository.findAll().stream().map(this::mapToPiattaformaResponse).toList();
    }

    private PiattaformaResponse mapToPiattaformaResponse(Piattaforma piattaforma) {
        PiattaformaResponse response = new PiattaformaResponse();
        response.setId(piattaforma.getId());
        response.setNome(piattaforma.getNome());
        response.setProduttore(piattaforma.getProduttore());
        response.setAnnoUscita(piattaforma.getAnnoUscita());
        response.setLogo(piattaforma.getLogo());
        return response;
    }
}
