package com.estudo.java.spring.CompaninVTR.Service.ProfessorService;

import com.estudo.java.spring.CompaninVTR.DTO.ProfessorDTO.ProfessorRequestDTO;
import com.estudo.java.spring.CompaninVTR.DTO.ProfessorDTO.ProfessorResponseDTO;
import com.estudo.java.spring.CompaninVTR.Model.Diciplina.Diciplina;
import com.estudo.java.spring.CompaninVTR.Model.Users.Professor;
import com.estudo.java.spring.CompaninVTR.Model.Role.UserRole;
import com.estudo.java.spring.CompaninVTR.Repository.Diciplina.DiciplinaRepository;
import com.estudo.java.spring.CompaninVTR.Repository.Users.ProfessorRepository;
import com.estudo.java.spring.CompaninVTR.exception.ProfessorExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProfessorService implements IProfessorService {

    @Autowired
    private ProfessorRepository repository;

    @Autowired
    private DiciplinaRepository dcrepository;

    @Override
    public ProfessorResponseDTO save(ProfessorRequestDTO dto) {
        var professorExistente = repository.findByNomeAndIsAtivoTrue(dto.nome())
                .orElseThrow(() -> new RuntimeException("Professor já existente na base de dados: " + dto.nome()));
        var diciplinasExistente = dcrepository.findByNomeDiciplinaAndIsAtivoTrue(String.valueOf(dto.diciplinas()));
        Professor professor = new Professor();
        professor.setNome(dto.nome());
        professor.setRole(UserRole.ADMIN);
        professor.setIdade(dto.idade());
        List diciplinas = dcrepository.findByNomeDiciplinaAndIsAtivoTrue(String.valueOf(dto.diciplinas()));
        List<Diciplina> disciplinas = Optional.ofNullable(dto.diciplinas())
                .orElse(List.of()) // se for null, usa lista vazia
                .stream()
                .map(nome -> {
                    Diciplina d = new Diciplina();
                    d.setNomeDiciplina(nome);
                    d.setProfessor(professor);
                    return d;
                }).toList();
        repository.save(professor);

        return new ProfessorResponseDTO(dto.nome(), dto.idade(), dto.diciplinas());
    }

    @Override
    public ProfessorResponseDTO update(String id, ProfessorRequestDTO dto) throws ProfessorExceptions {
        Professor professor = repository.findById(UUID.fromString(id)).orElseThrow(() -> new RuntimeException("Id do aluno não encontrado"));
        if (dto.nome() == null || dto.nome().isBlank()) throw new ProfessorExceptions("Nome do aluno é obrigatório");
        if (dto.idade() == null || dto.idade() <= 0) throw new ProfessorExceptions("Idade do aluno deve ser maior que zero");
        List diciplina = Collections.singletonList(dcrepository.findByNomeDiciplinaAndIsAtivoTrue(String.valueOf(dto.diciplinas())).isEmpty());
        professor.setNome(dto.nome());
        professor.setIdade(dto.idade());
        professor.setDiciplina((List<Diciplina>) diciplina);
        repository.save(professor);
        return new ProfessorResponseDTO(dto.nome(), dto.idade(), dto.diciplinas());
    }

    @Override
    public String delete(String id) {
        Professor professor = repository.findById(UUID.fromString(id)).orElseThrow(() -> new RuntimeException("Id do Professor não encontrado: " + id));
        professor.inativar();

        repository.save(professor);
        return "Professor inativado com sucesso!!!";
    }

    @Override
    public ProfessorResponseDTO getById(String id) {
        Professor professor = repository.findById(UUID.fromString(id)).orElseThrow(() -> new RuntimeException("Id do Professor não encontrado: " + id));
        Diciplina diciplina = (Diciplina) professor.getDiciplina();
        return new ProfessorResponseDTO(professor.getNome(), professor.getIdade(), Collections.singletonList(diciplina.getNomeDiciplina()));
    }

    @Override
    public List<ProfessorResponseDTO> getAll() { return repository.findByIsAtivoTrue().stream().map(ProfessorResponseDTO::new).toList(); }
}