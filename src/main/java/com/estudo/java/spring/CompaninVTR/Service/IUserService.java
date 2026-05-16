package com.estudo.java.spring.CompaninVTR.Service;

import com.estudo.java.spring.CompaninVTR.DTO.AlunoDTO.AlunoRequestDTO;
import com.estudo.java.spring.CompaninVTR.DTO.AlunoDTO.AlunoResponseDTO;
import com.estudo.java.spring.CompaninVTR.exception.AlunoExceptions;
import com.estudo.java.spring.CompaninVTR.exception.ProfessorExceptions;

public interface IUserService<REQUEST, RESPONSE> {
    RESPONSE save(REQUEST dto) throws AlunoExceptions, ProfessorExceptions;

    RESPONSE update(String id, REQUEST dto) throws AlunoExceptions, ProfessorExceptions;

    String delete(String id);

    RESPONSE getById(String id);
}
