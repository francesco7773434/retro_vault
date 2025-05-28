package it.epicode.retro_vault.giochi;

import it.epicode.retro_vault.common.CommonResponse;
import it.epicode.retro_vault.exceptions.NotFoundException;
import it.epicode.retro_vault.piattaforme.Piattaforma;
import it.epicode.retro_vault.piattaforme.PiattaformaRepository;
import it.epicode.retro_vault.recensioni.Recensione;
import it.epicode.retro_vault.recensioni.RecensioneRepository;
import it.epicode.retro_vault.recensioni.RecensioneResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GiocoService {
    private final GiocoRepository giocoRepository;
    private final PiattaformaRepository piattaformaRepository;
    private final RecensioneRepository recensioneRepository;

    public GiocoDettaglioResponse getById(Long id) {

        Gioco gioco = giocoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Gioco non trovato"));


        Piattaforma piattaforma = gioco.getPiattaforma();


        List<Recensione> recensioni = recensioneRepository.findByGiocoId(id);

        double votoMedio = 0.0;
        if (!recensioni.isEmpty()) {
            votoMedio = recensioni.stream()
                    .mapToInt(Recensione::getVoto)
                    .average()
                    .orElse(0.0);
        }


        GiocoDettaglioResponse response = new GiocoDettaglioResponse();
        BeanUtils.copyProperties(gioco, response);
        response.setPiattaformaId(piattaforma.getId());
        response.setPiattaformaNome(piattaforma.getNome());


        List<RecensioneResponse> recensioneResponses = recensioni.stream()
                .map(this::mapToRecensioneResponse)
                .collect(Collectors.toList());
        response.setTutteLeRecensioni(recensioneResponses);
        response.setVotoMedio(votoMedio);

        return response;
    }


    private RecensioneResponse mapToRecensioneResponse(Recensione recensione) {
        RecensioneResponse response = new RecensioneResponse();
        BeanUtils.copyProperties(recensione, response);
        response.setUtenteId(recensione.getUtente().getId());
        response.setUsernameUtente(recensione.getUtente().getUsername());
        response.setGiocoId(recensione.getGioco().getId());
        response.setTitoloGioco(recensione.getGioco().getTitolo());
        return response;
    }

    public CommonResponse createGioco(GiocoRequest request) {
        Gioco gioco = new Gioco();
        BeanUtils.copyProperties(request, gioco);
        Piattaforma piattaforma = piattaformaRepository.findById(request.getPiattaformaId())
                .orElseThrow(() -> new NotFoundException("Piattaforma non trovata"));
        gioco.setPiattaforma(piattaforma);
        giocoRepository.save(gioco);
        return new CommonResponse(gioco.getId());
    }

    public GiocoRequest updateGioco(Long id, GiocoRequest request) {
        Gioco gioco = giocoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Gioco non trovato"));

        BeanUtils.copyProperties(request, gioco);

        Piattaforma piattaforma = piattaformaRepository.findById(request.getPiattaformaId())
                .orElseThrow(() -> new NotFoundException("Piattaforma non trovata"));
        gioco.setPiattaforma(piattaforma);

        giocoRepository.save(gioco);
        return request;
    }


    public void deleteGioco(Long id) {
        if (!giocoRepository.existsById(id)) {
            throw new NotFoundException("Gioco non trovato");
        }
        giocoRepository.deleteById(id);
    }

    public Page<GiocoResponse> getAllGiochi(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<Gioco> giochi = giocoRepository.findAll(pageable);


        Page<GiocoResponse> giocoResponses = giochi.map(this::convertToGiocoResponse);
        return giocoResponses;
    }

    public GiocoResponse convertToGiocoResponse(Gioco gioco) {
        GiocoResponse response = new GiocoResponse();
        response.setId(gioco.getId());
        response.setTitolo(gioco.getTitolo());
        response.setDescrizione(gioco.getDescrizione());
        response.setImmagine(gioco.getImmagine());
        response.setAnnoUscita(gioco.getAnnoUscita());
        response.setGenere(gioco.getGenere());

        Piattaforma piattaforma = gioco.getPiattaforma();
        response.setPiattaformaId(piattaforma.getId());
        response.setPiattaformaNome(piattaforma.getNome());

        List<Recensione> recensioni = recensioneRepository.findByGiocoId(gioco.getId());
        double votoMedio = 0.0;
        if (!recensioni.isEmpty()) {
            votoMedio = recensioni.stream()
                    .mapToInt(Recensione::getVoto)
                    .average()
                    .orElse(0.0);
        }
        response.setVotoMedio(votoMedio);

        return response;
    }

    public Page<GiocoResponse> searchGiochi(
            String titolo, Integer annoUscita,
            int page, int size, String sort) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<Gioco> giochi = giocoRepository.findByTitoloAndAnnoUscita(titolo, annoUscita, pageable);

        return giochi.map(this::convertToGiocoResponse);
    }

}
