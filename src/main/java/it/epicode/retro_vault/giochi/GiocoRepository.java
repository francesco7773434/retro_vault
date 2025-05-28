package it.epicode.retro_vault.giochi;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GiocoRepository extends JpaRepository<Gioco, Long> {
    boolean existsByTitolo(String titolo);


    @Query("SELECT g FROM Gioco g " +
            "WHERE (:titolo IS NULL OR LOWER(g.titolo) LIKE LOWER(CONCAT('%', :titolo, '%'))) " +
            "AND (:annoUscita IS NULL OR g.annoUscita = :annoUscita)")
    Page<Gioco> findByTitoloAndAnnoUscita(
            @Param("titolo") String titolo,
            @Param("annoUscita") Integer annoUscita,
            Pageable pageable);
}
