package it.epicode.retro_vault.giochi;

import it.epicode.retro_vault.generi.Genere;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GiocoResponse {
    private Long id;
    private String titolo;
    private String descrizione;
    private String immagine;
    private Integer annoUscita;
    private Genere genere;              // enum
    private Long piattaformaId;
    private String piattaformaNome;
}
