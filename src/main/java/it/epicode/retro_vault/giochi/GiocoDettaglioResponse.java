package it.epicode.retro_vault.giochi;


import it.epicode.retro_vault.generi.Genere;
import it.epicode.retro_vault.recensioni.RecensioneResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GiocoDettaglioResponse {
    private Long id;
    private String titolo;
    private String descrizione;
    private String immagine;
    private Integer annoUscita;
    private Genere genere;
    private Long piattaformaId;
    private String piattaformaNome;
    private List<RecensioneResponse> tutteLeRecensioni;
}
