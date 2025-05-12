package it.epicode.retro_vault.generi;

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
@Table(name = "Generi")

public class Genere {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    @OneToMany(mappedBy = "genere")
    private List<Gioco> giochi;


}