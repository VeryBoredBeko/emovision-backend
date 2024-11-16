package com.boreebeko.emovision.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "news")
@Getter
@Setter
@SequenceGenerator(name = "SEQ_ID", sequenceName = "news_seq", allocationSize = 1)
public class News extends Base implements Serializable {

    @NotBlank(message = "Title is mandatory")
    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @NotBlank(message = "Title is mandatory")
    @Column(name = "text", columnDefinition = "text")
    private String text;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id", nullable = false, updatable = false, insertable = false)
    private List<Comment> comments;
}
