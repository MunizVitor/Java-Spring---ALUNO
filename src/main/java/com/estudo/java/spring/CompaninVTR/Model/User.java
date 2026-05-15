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
public abstract class User implements IEntityModel {

    private String nome;

    private String login;

    private String password;

    private int idade;

    @Override
    public boolean inativar(){
        return false;
    }

    @Override
    public boolean ativar(){
        return true;
    }

    public boolean isAtivo() {
        return this.isAtivo();
    }
}
