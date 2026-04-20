package com.estudo.java.spring.CompaninVTR.DTO.DiciplinaController;

import com.estudo.java.spring.CompaninVTR.Model.Diciplina;
import com.estudo.java.spring.CompaninVTR.Model.Professor;

import java.util.UUID;

public record DiciplinaGetDTO(UUID id, String nome, String nomeprofessor) {
    public DiciplinaGetDTO(Diciplina diciplina) { this(diciplina.getId(), diciplina.getNome(), diciplina.getProfessor().getNome()); }
}
