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


    public PiattaformaResponse(Piattaforma piattaforma) {
        this.id = piattaforma.getId();
        this.nome = piattaforma.getNome();
        this.produttore = piattaforma.getProduttore();
        this.annoUscita = piattaforma.getAnnoUscita();
        this.logo = piattaforma.getLogo();
    }
}
