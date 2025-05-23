package it.epicode.retro_vault.piattaforme;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PiattaformaRepository extends JpaRepository<Piattaforma, Long> {
    boolean existsByNome(String nome);
    Optional<Piattaforma> findByNome(String nome);
}
