package com.estudo.java.spring.CompaninVTR.Model;

import com.estudo.java.spring.CompaninVTR.DTO.AlunoPostDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
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
    private LocalDateTime dataCriacao;

    @Column(name = "is_Ativo")
    private boolean isAtivo;

    //em nossa alicação apenas deletamos logicamente os aluno
    public void inativarAluno (){
        this.isAtivo = false;
    }

    public void dataCricao(){
        this.dataCriacao = LocalDateTime.now();
    }

    public Aluno(AlunoPostDTO alunoCadastrar){
        this.nome = alunoCadastrar.nome();
        this.idade = alunoCadastrar.idade();
        this.isAtivo = true;
        dataCricao();
    }

}
