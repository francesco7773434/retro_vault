package it.epicode.retro_vault.auth;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
