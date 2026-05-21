package com.estudo.java.spring.CompaninVTR.DTO.DiciplinaDTO;

import com.estudo.java.spring.CompaninVTR.Model.Aluno;
import com.estudo.java.spring.CompaninVTR.Model.Diciplina;
import com.estudo.java.spring.CompaninVTR.Model.Professor;

import java.util.List;

public record DiciplinaResponseDTO(String nomeDiciplina, String professor, List<String> aluno) {
    public DiciplinaResponseDTO(Diciplina diciplina) {
        this(diciplina.getNomeDiciplina(), diciplina.getProfessor().getNome(), diciplina.getAluno()
                .stream()
                .map(d -> d.getNome())
                .toList()
        );
    }
}
