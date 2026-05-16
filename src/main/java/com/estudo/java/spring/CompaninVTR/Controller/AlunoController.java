package com.estudo.java.spring.CompaninVTR.Controller;

import com.estudo.java.spring.CompaninVTR.DTO.AlunoDTO.AlunoRequestDTO;
import com.estudo.java.spring.CompaninVTR.DTO.AlunoDTO.AlunoResponseDTO;
import com.estudo.java.spring.CompaninVTR.Service.AlunoService.AlunoService;
import com.estudo.java.spring.CompaninVTR.DTO.AlunoDTO.AlunoGetDTO;
import com.estudo.java.spring.CompaninVTR.DTO.AlunoDTO.AlunoPostDTO;
import com.estudo.java.spring.CompaninVTR.Repository.AlunoRepository;
import com.estudo.java.spring.CompaninVTR.Service.AlunoService.IAlunoService;
import com.estudo.java.spring.CompaninVTR.exception.AlunoExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController extends AbstractUserController<AlunoRequestDTO, AlunoResponseDTO> {

    @Autowired
    AlunoRepository repository;

    @Autowired
    IAlunoService service;

    public AlunoController(IAlunoService service){
        super(service);
    }

}
