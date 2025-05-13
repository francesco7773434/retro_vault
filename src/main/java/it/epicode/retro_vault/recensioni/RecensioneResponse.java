package it.epicode.retro_vault.recensioni;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecensioneResponse {
    private Long id;
    private Long utenteId;
    private String username;
    private Long giocoId;
    private String titoloGioco;
    private String commento;
    private Integer voto;
    private LocalDateTime dataRecensione;
}
