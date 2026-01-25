package com.estudo.java.spring.CompaninVTR.DTO;

import com.estudo.java.spring.CompaninVTR.Model.Aluno;

import java.util.UUID;

public record AlunoGetDTO(UUID id, String nome, Integer idade) {
    public AlunoGetDTO (Aluno aluno){
        this(aluno.getId(), aluno.getNome(), aluno.getIdade());
    }
}
