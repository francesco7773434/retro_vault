package it.epicode.retro_vault.piattaforme;

import it.epicode.retro_vault.common.CommonResponse;
import it.epicode.retro_vault.exceptions.NotFoundException;
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

    public PiattaformaResponse getPiattaformaById(Long id) {
        Piattaforma piattaforma = piattaformaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Piattaforma non trovata"));
        return mapToPiattaformaResponse(piattaforma);
    }

    public CommonResponse createPiattaforma(PiattaformaRequest request) {
        Piattaforma piattaforma = new Piattaforma();
        piattaforma.setNome(request.getNome());
        piattaforma.setProduttore(request.getProduttore());
        piattaforma.setAnnoUscita(request.getAnnoUscita());
        piattaforma.setLogo(request.getLogo());
        piattaformaRepository.save(piattaforma);
        return new CommonResponse(piattaforma.getId());
    }

    public PiattaformaRequest updatePiattaforma(Long id, PiattaformaRequest request) {
        Piattaforma piattaforma = piattaformaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Piattaforma non trovata"));
        piattaforma.setNome(request.getNome());
        piattaforma.setProduttore(request.getProduttore());
        piattaforma.setAnnoUscita(request.getAnnoUscita());
        piattaforma.setLogo(request.getLogo());
        piattaformaRepository.save(piattaforma);
        return request;
    }

    public void deletePiattaforma(Long id) {
        if (!piattaformaRepository.existsById(id)) {
            throw new NotFoundException("Piattaforma non trovata");
        }
        piattaformaRepository.deleteById(id);
    }
}
