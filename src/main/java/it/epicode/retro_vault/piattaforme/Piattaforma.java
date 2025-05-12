package it.epicode.retro_vault.piattaforme;

import it.epicode.retro_vault.giochi.Gioco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Piattaforma")

public class Piattaforma {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    @OneToMany(mappedBy = "piattaforma")
    private List<Gioco> giochi;


}