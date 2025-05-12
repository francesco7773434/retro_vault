package it.epicode.retro_vault.utenti;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
