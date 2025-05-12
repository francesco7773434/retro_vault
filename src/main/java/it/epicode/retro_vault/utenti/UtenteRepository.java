package it.epicode.retro_vault.utenti;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtenteRepository extends  JpaRepository<Utente, Long>  {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    Optional<Utente> findByUsername(String username);
}
