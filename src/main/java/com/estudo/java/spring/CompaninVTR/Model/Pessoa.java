package com.estudo.java.spring.CompaninVTR.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@MappedSuperclass
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    private int idade;

    @Column(name = "is_Ativo")
    private boolean isAtivo  = true;

    @CreationTimestamp
    private Instant createdPerson;

    @UpdateTimestamp
    private Instant updatePerson;

    public void inativar(){ this.isAtivo = false; }
    public void ativar(){ this.isAtivo = true; }

}
