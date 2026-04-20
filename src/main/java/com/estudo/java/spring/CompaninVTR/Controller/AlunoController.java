package com.estudo.java.spring.CompaninVTR.Controller;

import com.estudo.java.spring.CompaninVTR.Service.AlunoService.AlunoService;
import com.estudo.java.spring.CompaninVTR.DTO.AlunoDTO.AlunoGetDTO;
import com.estudo.java.spring.CompaninVTR.DTO.AlunoDTO.AlunoPostDTO;
import com.estudo.java.spring.CompaninVTR.Repository.AlunoRepository;
import com.estudo.java.spring.CompaninVTR.exception.AlunoExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
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
