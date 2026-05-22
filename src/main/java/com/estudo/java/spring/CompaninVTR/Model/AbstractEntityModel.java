package com.estudo.java.spring.CompaninVTR.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@MappedSuperclass
public abstract class AbstractEntityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id = null;

    @CreationTimestamp
    Instant createdAt = Instant.now();

    @UpdateTimestamp
    Instant updatedAt = Instant.now();

    @Column(nullable = false)
    private Boolean isAtivo = true;

    public void inativar() {
        isAtivo = false;
    }

    public void ativar(){
        isAtivo = true;
    }

}
