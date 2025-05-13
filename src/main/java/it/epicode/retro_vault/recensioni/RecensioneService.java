package it.epicode.retro_vault.recensioni;

import it.epicode.retro_vault.common.CommonResponse;
import it.epicode.retro_vault.exceptions.NotFoundException;
import it.epicode.retro_vault.giochi.GiocoRepository;
import it.epicode.retro_vault.utenti.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RecensioneService {
    @Autowired
    private RecensioneRepository recensioneRepository;
    @Autowired
    private GiocoRepository giocoRepository;
    @Autowired
    private UtenteRepository utenteRepository;

    public CommonResponse createRecensione(RecensioneRequest request) {
        Recensione recensione = new Recensione();
        recensione.setVoto(request.getVoto());
        recensione.setCommento(request.getCommento());
        recensione.setGioco(giocoRepository.findById(request.getGiocoId())
                .orElseThrow(() -> new NotFoundException("Gioco non trovato")));
        recensione.setUtente(utenteRepository.findById(request.getUtenteId())
                .orElseThrow(() -> new NotFoundException("Utente non trovato")));
        recensioneRepository.save(recensione);
        return new CommonResponse(recensione.getId());
    }

    public RecensioneResponse getRecensioneById(Long id) {
        Recensione recensione = recensioneRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Recensione non trovata"));
        return toResponse(recensione);
    }

    public Page<RecensioneResponse> getAllRecensioni(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("dataRecensione").descending());
        Page<Recensione> recensioni = recensioneRepository.findAll(pageable);
        return recensioni.map(this::toResponse);
    }

    public Page<RecensioneResponse> getRecensioniByGioco(Long giocoId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("dataRecensione").descending());
        Page<Recensione> recensioni = recensioneRepository.findByGiocoId(giocoId, pageable);
        return recensioni.map(this::toResponse);
    }

    private RecensioneResponse toResponse(Recensione recensione) {
        return new RecensioneResponse(
                recensione.getId(),
                recensione.getUtente().getId(),
                recensione.getUtente().getUsername(),
                recensione.getGioco().getId(),
                recensione.getGioco().getTitolo(),
                recensione.getCommento(),
                recensione.getVoto(),
                recensione.getDataRecensione()
        );
    }

    public RecensioneRequest updateRecensione(Long id, RecensioneRequest request) {
        Recensione recensione = recensioneRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Recensione non trovata"));
        recensione.setVoto(request.getVoto());
        recensione.setCommento(request.getCommento());
        recensioneRepository.save(recensione);
        return request;
    }
    public void deleteRecensione(Long id) {
        if (!recensioneRepository.existsById(id)) {
            throw new NotFoundException("Recensione non trovata");
        }
        recensioneRepository.deleteById(id);
    }
}
