package it.epicode.retro_vault.piattaforme;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PiattaformaResponse {
    private Long id;
    private String nome;
    private String produttore;
    private Integer annoUscita;
    private String logo;
}
