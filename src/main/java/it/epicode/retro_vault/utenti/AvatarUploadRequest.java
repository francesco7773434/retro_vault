package it.epicode.retro_vault.utenti;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.multipart.MultipartFile;

public class AvatarUploadRequest {
    @Schema(type = "string", format = "binary", description = "File immagine avatar")
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
