package it.epicode.retro_vault.giochi;

import it.epicode.retro_vault.generi.Genere;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GiocoRequest {
    @NotBlank(message = "Il titolo non può essere vuoto")
    private String titolo;
    @NotBlank(message = "La descrizione non può essere vuota")
    private String descrizione;
    @NotBlank(message = "L'immagine non può essere vuota")
    private String immagine;
    @NotBlank(message = "L'anno di uscita non può essere vuoto")
    private Integer annoUscita;
    @NotBlank(message = "Il genere non può essere vuoto")
    private Genere genere;
    @NotBlank(message = "L'ID della piattaforma non può essere vuoto")
    private Long piattaformaId;
    private String videoGameplay;
}
