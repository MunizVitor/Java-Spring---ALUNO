package com.estudo.java.spring.CompaninVTR.Controller;

import com.estudo.java.spring.CompaninVTR.AlunoService.AlunoService;
import com.estudo.java.spring.CompaninVTR.DTO.AlunoGetDTO;
import com.estudo.java.spring.CompaninVTR.DTO.AlunoPostDTO;
import com.estudo.java.spring.CompaninVTR.Model.Aluno;
import com.estudo.java.spring.CompaninVTR.Repository.AlunoRepository;
import com.estudo.java.spring.CompaninVTR.exception.AlunoExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    AlunoRepository repository;

    @Autowired
    AlunoService service;

    @GetMapping
    public List<AlunoGetDTO> getAll(){
        return service.buscarTodosAlunos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoGetDTO> getd(@PathVariable(name = "id", required = true) String id) throws AlunoExceptions {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarAlunoPorId(id));
    }

    @PostMapping("/cadastro")
    public ResponseEntity cadastrarAluno(@RequestBody AlunoPostDTO alunoCadastrar) throws AlunoExceptions {
        return ResponseEntity.status(HttpStatus.OK).body(service.cadastrarAluno(alunoCadastrar));
    }

    @DeleteMapping("/{id}/deletar")//em nossa alicação apenas deletamos logicamente os alunos
    public ResponseEntity inativarAluno(@PathVariable(name = "id") String id) throws AlunoExceptions {
        return ResponseEntity.status(HttpStatus.OK).body(service.deletarAluno(id));
    }
}
