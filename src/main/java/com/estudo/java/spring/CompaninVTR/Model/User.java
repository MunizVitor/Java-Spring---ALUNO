package com.estudo.java.spring.CompaninVTR.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@MappedSuperclass
public abstract class User extends AbstractEntityModel {

    private String nome;

    private String login;

    private String password;

    private int idade;
}
