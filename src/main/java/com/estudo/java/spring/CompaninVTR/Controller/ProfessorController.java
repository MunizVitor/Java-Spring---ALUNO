package com.estudo.java.spring.CompaninVTR.Controller;

import com.estudo.java.spring.CompaninVTR.Service.ProfessorService.IProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/professores")
public class ProfessorController extends AbstractUserController {

    @Autowired
    private IProfessorService service;

    public ProfessorController(IProfessorService service){ super (service); }

}
