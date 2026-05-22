package com.estudo.java.spring.CompaninVTR.Service.AlunoService;

import com.estudo.java.spring.CompaninVTR.DTO.AlunoDTO.AlunoRequestDTO;
import com.estudo.java.spring.CompaninVTR.DTO.AlunoDTO.AlunoResponseDTO;
import com.estudo.java.spring.CompaninVTR.Model.Users.Aluno;
import com.estudo.java.spring.CompaninVTR.Model.Diciplina.Diciplina;
import com.estudo.java.spring.CompaninVTR.Model.Role.UserRole;
import com.estudo.java.spring.CompaninVTR.Repository.Users.AlunoRepository;
import com.estudo.java.spring.CompaninVTR.Repository.Diciplina.DiciplinaRepository;
import com.estudo.java.spring.CompaninVTR.exception.AlunoExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class AlunoService implements IAlunoService {

    @Autowired
    AlunoRepository repository;

    @Autowired
    DiciplinaRepository dcrepository;

    @Override
    public List getAll() {
        return repository.findByIsAtivoTrue().stream().map(AlunoResponseDTO::new).toList();
    }

    @Override
    public AlunoResponseDTO save(AlunoRequestDTO dto) throws AlunoExceptions {
        if (dto.nome() == null || dto.nome().isBlank()) {
            throw new AlunoExceptions("Nome do aluno é obrigatório");
        }
        if (dto.idade() == null || dto.idade() <= 0) {
            throw new AlunoExceptions("Idade do aluno deve ser maior que zero");
        }
        List diciplina = Collections.singletonList(dcrepository.findByNomeDiciplinaAndIsAtivoTrue(dto.diciplina()).isEmpty());
        Aluno aluno = new Aluno();
        aluno.setNome(dto.nome());
        aluno.setIdade(dto.idade());
        aluno.setRole(UserRole.USER);
        aluno.setDiciplina((Diciplina) diciplina);
        repository.save(aluno);
        return new AlunoResponseDTO(dto.nome(), dto.idade(), dto.diciplina());
    }

    @Override
    public AlunoResponseDTO update(String id, AlunoRequestDTO dto) throws AlunoExceptions {

        Aluno aluno = repository.findById(UUID.fromString(id)).orElseThrow(() -> new RuntimeException("Id do aluno não encontrado"));

        if (dto.nome() == null || dto.nome().isBlank()) throw new AlunoExceptions("Nome do aluno é obrigatório");
        if (dto.idade() == null || dto.idade() <= 0) throw new AlunoExceptions("Idade do aluno deve ser maior que zero");

        List diciplina = dcrepository.findByNomeDiciplinaAndIsAtivoTrue(dto.diciplina());
        aluno.setNome(dto.nome());
        aluno.setIdade(dto.idade());
        aluno.setDiciplina((Diciplina) diciplina);
        repository.save(aluno);
        return new AlunoResponseDTO(dto.nome(), dto.idade(), dto.diciplina());
    }

    @Override
    public String delete(String idAluno) {
        Aluno alunoExistente = repository.findById(UUID.fromString(idAluno)).orElseThrow(() -> new RuntimeException("O Id do aluno esta incorreto: " + idAluno));
        alunoExistente.inativar();
        repository.save(alunoExistente);
        return "Aluno inativado com sucesso";
    }

    @Override
    public AlunoResponseDTO getById(String idAluno) {
        Aluno aluno = repository.findById(UUID.fromString(idAluno)).orElseThrow(() -> new RuntimeException("O Id do aluno não consta na base de dados"));
        Diciplina diciplina = aluno.getDiciplina();
        return new AlunoResponseDTO(aluno.getNome(), aluno.getIdade(), diciplina.getNomeDiciplina());
    }
}
