package com.boreebeko.emovision.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Sign In Request")
public class SignInRequest {

    @Schema(description = "Username", example = "Beknur")
    @Size(min = 5, max = 50, message = "Username length must be between 5 and 50 symbols")
    private String username;

    @Schema(description = "Password", example = "my_Ultrasecret1_password")
    @Size(min = 8, max = 255, message = "Password length must be between 5 and 255 symbols")
    private String password;
}
