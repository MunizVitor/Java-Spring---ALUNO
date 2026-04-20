package com.estudo.java.spring.CompaninVTR.Controller;

import com.estudo.java.spring.CompaninVTR.DTO.ProfessorDTO.ProfessorGetDTO;
import com.estudo.java.spring.CompaninVTR.DTO.ProfessorDTO.ProfessorPostDTO;
import com.estudo.java.spring.CompaninVTR.Service.ProfessorService.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService pfService;

    @PostMapping
    public ResponseEntity<ProfessorGetDTO> createProfessor(@RequestBody @Validated ProfessorPostDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(pfService.createProfessor(dto));
    }
}
