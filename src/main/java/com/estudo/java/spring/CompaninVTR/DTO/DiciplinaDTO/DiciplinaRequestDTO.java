package com.estudo.java.spring.CompaninVTR.DTO.DiciplinaDTO;

import com.estudo.java.spring.CompaninVTR.Model.Aluno;

import java.util.List;

public record DiciplinaRequestDTO(String nomeDiciplina, String professor, List<Aluno> aluno) {
}
