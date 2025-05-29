package it.epicode.retro_vault.recensioni;

import it.epicode.retro_vault.giochi.Gioco;
import it.epicode.retro_vault.utenti.Utente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecensioneRepository extends JpaRepository<Recensione, Long> {
    List<Recensione> findByGiocoId(Long giocoId);

    Page<Recensione> findByGiocoId(Long giocoId, Pageable pageable);

    Page<Recensione> findByUtenteId(Long utenteId, Pageable pageable);
    boolean existsByUtenteAndGioco(Utente utente, Gioco gioco);

    @Query("""
    SELECT r FROM Recensione r
    WHERE (:titolo IS NULL OR LOWER(r.gioco.titolo) LIKE LOWER(CONCAT('%', :titolo, '%')))
""")
    Page<Recensione> searchByTitoloGioco(
            @Param("titolo") String titolo,
            Pageable pageable
    );
}
