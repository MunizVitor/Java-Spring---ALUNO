package com.estudo.java.spring.CompaninVTR.DTO;

import com.estudo.java.spring.CompaninVTR.Model.Aluno;

public record AlunoGetDTO(String nome, Integer idade) {
    public AlunoGetDTO (Aluno aluno){
        this(aluno.getNome(), aluno.getIdade());
    }
}
