package it.epicode.retro_vault.piattaforme;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PiattaformaRequest {
    @NotBlank(message = "Il nome non può essere vuoto")
    private String nome;
    @NotBlank(message = "Il produttore non può essere vuoto")
    private String produttore;
    @NotBlank(message = "L'anno di uscita non può essere vuoto")
    private Integer annoUscita;
    private String logo;
}
