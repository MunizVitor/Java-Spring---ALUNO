package com.estudo.java.spring.CompaninVTR.DTO.ProfessorDTO;

import com.estudo.java.spring.CompaninVTR.Model.Diciplina.Diciplina;
import com.estudo.java.spring.CompaninVTR.Model.Users.Professor;

import java.util.Collections;
import java.util.List;

public record ProfessorResponseDTO (String nome, Integer idade, List<String> diciplinas){
    public ProfessorResponseDTO(Professor professor, Diciplina diciplina){
        this(professor.getNome(), professor.getIdade(), Collections.singletonList(diciplina.getNomeDiciplina()));
    }

    public ProfessorResponseDTO(Professor professor) {
        this(professor.getNome(), professor.getIdade(), professor.getDiciplina()
                .stream()
                .map(d -> d.getNomeDiciplina())
                .toList()
        );
    }

}
