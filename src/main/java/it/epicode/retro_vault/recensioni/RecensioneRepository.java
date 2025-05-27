package it.epicode.retro_vault.recensioni;

import it.epicode.retro_vault.giochi.Gioco;
import it.epicode.retro_vault.utenti.Utente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecensioneRepository extends JpaRepository<Recensione, Long> {
    List<Recensione> findByGiocoId(Long giocoId);

    Page<Recensione> findByGiocoId(Long giocoId, Pageable pageable);

    Page<Recensione> findByUtenteId(Long utenteId, Pageable pageable);
    boolean existsByUtenteAndGioco(Utente utente, Gioco gioco);
}
