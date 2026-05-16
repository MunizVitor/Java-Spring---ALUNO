package com.estudo.java.spring.CompaninVTR.Controller;

import com.estudo.java.spring.CompaninVTR.Service.AlunoService.IAlunoService;
import com.estudo.java.spring.CompaninVTR.Service.ProfessorService.IProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

public abstract class AbstractController<T> {
}
