package com.estudo.java.spring.CompaninVTR.AlunoService;

import com.estudo.java.spring.CompaninVTR.DTO.AlunoGetDTO;
import com.estudo.java.spring.CompaninVTR.Model.Aluno;
import com.estudo.java.spring.CompaninVTR.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository repository;

    public List<AlunoGetDTO> buscarTodosAlunos(){
        List<AlunoGetDTO> listAluno = repository.findByIsAtivo(true).stream().map(AlunoGetDTO::new).toList();
        return listAluno;
    }

    public AlunoGetDTO buscarAlunoPorId(String id){
        UUID idConvertido = UUID.fromString(id);
        Aluno aluno = repository.findByIdAndIsAtivoTrue(idConvertido).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        return new AlunoGetDTO(aluno);
    }

    public String deletarAluno(String id){
        UUID idConvertido = UUID.fromString(id);
        Aluno aluno = repository.getById(idConvertido);
        aluno.inativarAluno();
        repository.saveAndFlush(aluno);
        return "Aluno 'DELETADO COM SUUCESSO' !!!!";
    }

}
