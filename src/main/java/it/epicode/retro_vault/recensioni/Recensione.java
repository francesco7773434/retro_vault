package it.epicode.retro_vault.recensioni;


import com.fasterxml.jackson.annotation.JsonBackReference;
import it.epicode.retro_vault.giochi.Gioco;
import it.epicode.retro_vault.utenti.Utente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Recensioni")

public class Recensione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;
    @ManyToOne
    @JoinColumn(name = "gioco_id")
    @JsonBackReference
    private Gioco gioco;
    private String commento;
    private Integer voto;
    private LocalDateTime dataRecensione;

    @PrePersist
    public void prePersist() {
        this.dataRecensione = LocalDateTime.now();
    }


}