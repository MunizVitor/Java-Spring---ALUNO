package com.estudo.java.spring.CompaninVTR.DTO.AlunoDTO;

import com.estudo.java.spring.CompaninVTR.Model.Aluno;
import com.estudo.java.spring.CompaninVTR.Model.Diciplina;
import com.estudo.java.spring.CompaninVTR.Model.User;

public record AlunoResponseDTO (String nome, Integer idade, String diciplina){
    public AlunoResponseDTO(Aluno aluno, Diciplina diciplina){
        this(aluno.getNome(), aluno.getIdade(), diciplina.getNomeDiciplina());
    }
}
