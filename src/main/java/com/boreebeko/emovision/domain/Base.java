package com.boreebeko.emovision.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class Base implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID")
    @Column(name = "id")
    private Long id;

    @Embedded
    private Audit audit;

    @PrePersist
    public void fillCreatedOn() {
        audit.setCreatedOn(LocalDateTime.now());
    }

    @PreUpdate
    public void fillUpdatedOn() {
        audit.setUpdatedOn(LocalDateTime.now());
    }
}
