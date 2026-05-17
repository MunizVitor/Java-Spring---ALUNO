package com.estudo.java.spring.CompaninVTR.Controller;

import com.estudo.java.spring.CompaninVTR.DTO.AlunoDTO.AlunoRequestDTO;
import com.estudo.java.spring.CompaninVTR.DTO.AlunoDTO.AlunoResponseDTO;
import com.estudo.java.spring.CompaninVTR.Repository.AlunoRepository;
import com.estudo.java.spring.CompaninVTR.Service.AlunoService.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
