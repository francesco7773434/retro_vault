package it.epicode.retro_vault.piattaforme;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "Piattaforme")

public class Piattaforma {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String produttore;
    private Integer annoUscita;
    private String logo;
    @OneToMany(mappedBy = "piattaforma")
    @JsonManagedReference
    private List<Gioco> giochi;


}