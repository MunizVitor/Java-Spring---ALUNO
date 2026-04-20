package com.estudo.java.spring.CompaninVTR.DTO.ProfessorDTO;

import com.estudo.java.spring.CompaninVTR.Model.Diciplina;
import com.estudo.java.spring.CompaninVTR.Model.Professor;

import java.util.List;
import java.util.UUID;

public record ProfessorGetDTO(UUID id, String nome, List<Diciplina> diciplina) {
    public ProfessorGetDTO(Professor professor) { this(professor.getId(), professor.getNome(), professor.getDiciplina());}
}
