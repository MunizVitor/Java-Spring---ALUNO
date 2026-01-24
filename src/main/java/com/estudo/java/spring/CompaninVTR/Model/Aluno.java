package com.estudo.java.spring.CompaninVTR.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    private String nome;
    private Integer idade;

    @Column(name = "data_criacao")
    private Date dataCriacao;

    @Column(name = "is_Ativo")
    private boolean isAtivo;


    public void inativarAluno (){
        isAtivo = false;
    }

}
