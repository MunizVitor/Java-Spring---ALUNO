package com.estudo.java.spring.CompaninVTR.DTO.DiciplinaDTO;

import com.estudo.java.spring.CompaninVTR.Model.Diciplina.Diciplina;

import java.util.List;

public record DiciplinaResponseDTO(String nomeDiciplina, String professor, List<String> aluno) {
    public DiciplinaResponseDTO(Diciplina diciplina) {
        this(diciplina.getNomeDiciplina(), diciplina.getProfessor().getNome(), diciplina.getAlunos()
                .stream()
                .map(d -> d.getNome())
                .toList()
        );
    }
}
