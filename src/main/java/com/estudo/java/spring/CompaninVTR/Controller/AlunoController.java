package com.estudo.java.spring.CompaninVTR.Controller;

import com.estudo.java.spring.CompaninVTR.AlunoService.AlunoService;
import com.estudo.java.spring.CompaninVTR.DTO.AlunoGetDTO;
import com.estudo.java.spring.CompaninVTR.DTO.AlunoPostDTO;
import com.estudo.java.spring.CompaninVTR.Model.Aluno;
import com.estudo.java.spring.CompaninVTR.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<AlunoGetDTO> getd(@PathVariable(name = "id", required = true) String id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarAlunoPorId(id));
    }

    @PostMapping("/cadastro")
    public ResponseEntity cadastrarAluno(@RequestBody AlunoPostDTO alunoCadastrar){
        Aluno aluno = new Aluno(alunoCadastrar);
        return ResponseEntity.status(HttpStatus.OK).body(repository.saveAndFlush(aluno));
    }

    @DeleteMapping("/{id}/deletar")//em nossa alicação apenas deletamos logicamente os alunos
    public ResponseEntity inativarAluno(@RequestBody AlunoGetDTO aluno){
        Aluno alunoInativado = new Aluno();
        alunoInativado.inativarAluno();
        repository.saveAndFlush(alunoInativado);
        return ResponseEntity.status(HttpStatus.OK).body("Aluno 'DELETADO COM SUUCESSO' !!!!");
    }
}
