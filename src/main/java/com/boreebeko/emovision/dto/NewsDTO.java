package com.boreebeko.emovision.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "News Data Transfer Object")
@Getter
@Setter
public class NewsDTO {

    @Schema(description = "News title", example = "My Title")
    public String title;

    @Schema(description = "News description", example = "My Description")
    public String description;

    @Schema(description = "News content", example = "Hello, World!")
    public String text;

    public AuditDTO audit;
}
