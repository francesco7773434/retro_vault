package it.epicode.retro_vault.recensioni;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecensioneRequest {
    @NotBlank(message = "L'ID dell'utente non può essere vuoto")
    private Long utenteId;
    @NotBlank(message = "L'ID del gioco non può essere vuoto")
    private Long giocoId;
    @NotBlank(message = "Il commento non può essere vuoto")
    private String commento;
    private Integer voto;
}
