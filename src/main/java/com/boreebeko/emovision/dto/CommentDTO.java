package com.boreebeko.emovision.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Comment Data Transfer Object")
public class CommentDTO {

    @Schema(description = "Comment content", example = "My good comment")
    private String text;
}
