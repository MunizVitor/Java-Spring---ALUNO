package com.estudo.java.spring.CompaninVTR.DTO.ProfessorDTO;

import com.estudo.java.spring.CompaninVTR.Model.Diciplina;

import java.util.List;

public record ProfessorPostDTO(String nome, int idade, List<String> disciplinas) {
}

