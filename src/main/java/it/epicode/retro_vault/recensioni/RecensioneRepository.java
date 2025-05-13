package it.epicode.retro_vault.recensioni;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecensioneRepository extends JpaRepository<Recensione, Long> {
    List<Recensione> findByGiocoId(Long giocoId);
}
