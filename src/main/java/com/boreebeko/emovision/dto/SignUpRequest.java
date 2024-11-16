package com.boreebeko.emovision.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Sigh Up Request")
public class SignUpRequest {

    @Schema(description = "Username", example = "Beknur")
    @Size(min = 5, max = 50, message = "Username length must be between 5 and 50 symbols")
    @NotBlank(message = "Username can't be blank")
    private String username;

    @Schema(description = "Email address", example = "beknur@gmail.com")
    @Size(min = 5, max = 255, message = "Email address length must be between 5 and 255 symbols")
    @NotBlank(message = "Email address can't be blank")
    @Email(message = "Email address must be in user@example.com format")
    private String email;

    @Schema(description = "Password", example = "my_Ultrasecret1_password")
    @Size(min = 8, max = 255, message = "Password length must be between 5 and 255 symbols")
    private String password;
}
