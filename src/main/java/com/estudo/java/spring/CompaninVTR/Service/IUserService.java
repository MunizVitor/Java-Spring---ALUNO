package com.estudo.java.spring.CompaninVTR.Service;

import com.estudo.java.spring.CompaninVTR.exception.AlunoExceptions;
import com.estudo.java.spring.CompaninVTR.exception.ProfessorExceptions;

import java.util.List;

public interface IUserService<REQUEST, RESPONSE> {

    List getAll();

    RESPONSE save(REQUEST dto) throws AlunoExceptions, ProfessorExceptions;

    RESPONSE update(String id, REQUEST dto) throws AlunoExceptions, ProfessorExceptions;

    String delete(String id);

    RESPONSE getById(String id);
}
