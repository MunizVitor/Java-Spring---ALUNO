package com.estudo.java.spring.CompaninVTR.AlunoService;

import com.estudo.java.spring.CompaninVTR.DTO.AlunoGetDTO;
import com.estudo.java.spring.CompaninVTR.DTO.AlunoPostDTO;
import com.estudo.java.spring.CompaninVTR.Model.Aluno;
import com.estudo.java.spring.CompaninVTR.Repository.AlunoRepository;
import com.estudo.java.spring.CompaninVTR.exception.AlunoExceptions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository repository;

    public List<AlunoGetDTO> buscarTodosAlunos(){
        List<AlunoGetDTO> listAluno = repository.findByIsAtivo(true).stream().map(AlunoGetDTO::new).toList();
        return listAluno;
    }

    public AlunoGetDTO buscarAlunoPorId(String id) throws AlunoExceptions {

        UUID idConvertido;
        try {
            idConvertido = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            throw new AlunoExceptions("ID inválido: " + id);
        }

        Optional<Aluno> optionalAluno = repository.findById(idConvertido);

        if (optionalAluno.isEmpty()) {
            throw new AlunoExceptions("Aluno não encontrado através do ID: " + id);
        }

        Aluno aluno = optionalAluno.get();

        if (!aluno.isAtivo()) {
            throw new AlunoExceptions("Aluno inativado: " + id);
        }
        return new AlunoGetDTO(aluno);
    }

    private Optional<Aluno> getOptional(UUID idConvertido) {
        Optional<Aluno> optionalAluno = repository.findById(idConvertido);
        return optionalAluno;
    }

    public AlunoPostDTO cadastrarAluno(AlunoPostDTO alunoCadastro) throws AlunoExceptions {

        if (alunoCadastro.nome() == null || alunoCadastro.nome().isBlank()) {
            throw new AlunoExceptions("Nome do aluno é obrigatório");
        }
        if (alunoCadastro.idade() == null || alunoCadastro.idade() <= 0) {
            throw new AlunoExceptions("Idade do aluno deve ser maior que zero");
        }

        Aluno aluno = new Aluno(alunoCadastro);
        return alunoCadastro;
    }


    public String deletarAluno(String id) throws AlunoExceptions {
        UUID idConvertido;
        try {
            idConvertido = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            throw new AlunoExceptions("ID inválido: " + id);
        }

        Optional<Aluno> optionalAluno = repository.findById(idConvertido);
        if (optionalAluno.isEmpty()) {
            throw new AlunoExceptions("Aluno não encontrado através do ID: " + id);
        }
        Aluno aluno = new Aluno();
        BeanUtils.copyProperties(optionalAluno, aluno);
        aluno.inativarAluno();
        repository.saveAndFlush(aluno);
        return "Aluno 'DELETADO COM SUUCESSO' !!!!";
    }

}
