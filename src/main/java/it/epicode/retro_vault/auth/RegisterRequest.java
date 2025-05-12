package it.epicode.retro_vault.auth;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
}
