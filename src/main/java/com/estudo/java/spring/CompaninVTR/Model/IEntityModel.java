package com.estudo.java.spring.CompaninVTR.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

public interface IEntityModel{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id = null;

    @CreationTimestamp
    Instant createdAt = Instant.now();

    @UpdateTimestamp
    Instant updatedAt = Instant.now();

    boolean isAtivo = true;

    public boolean inativar();

    public boolean ativar();

}
