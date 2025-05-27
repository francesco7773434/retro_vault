package it.epicode.retro_vault.giochi;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import it.epicode.retro_vault.generi.Genere;
import it.epicode.retro_vault.piattaforme.Piattaforma;
import it.epicode.retro_vault.recensioni.Recensione;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Giochi")

public class Gioco {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String titolo;
    private String descrizione;
    private String immagine;
    private Integer annoUscita;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genere genere;
    @ManyToOne
    @JoinColumn(name = "piattaforma_id")
    @JsonBackReference
    private Piattaforma piattaforma;
    @OneToMany(mappedBy = "gioco",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Recensione> recensioni;



}