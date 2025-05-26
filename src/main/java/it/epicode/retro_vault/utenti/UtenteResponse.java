package it.epicode.retro_vault.utenti;

import it.epicode.retro_vault.auth.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtenteResponse {
    private Long id;
    private String username;
    private String email;
    private String nome;
    private String cognome;
    private String avatar;
    private Set<Role> roles;

    public UtenteResponse(Utente utente) {
        this.id = utente.getId();
        this.username = utente.getUsername();
        this.email = utente.getEmail();
        this.avatar = utente.getAvatar();
        this.nome = utente.getNome();
        this.cognome = utente.getCognome();
        this.roles = utente.getRoles();
    }
}
