package com.estudo.java.spring.CompaninVTR.DTO.ProfessorDTO;

import java.util.List;

public record ProfessorRequestDTO (String nome, Integer idade, List<String> diciplinas){
}
