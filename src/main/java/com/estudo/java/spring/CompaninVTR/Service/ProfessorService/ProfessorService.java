package com.estudo.java.spring.CompaninVTR.Service.ProfessorService;

import com.estudo.java.spring.CompaninVTR.DTO.ProfessorDTO.ProfessorRequestDTO;
import com.estudo.java.spring.CompaninVTR.DTO.ProfessorDTO.ProfessorResponseDTO;
import com.estudo.java.spring.CompaninVTR.Model.Diciplina;
import com.estudo.java.spring.CompaninVTR.Model.Professor;
import com.estudo.java.spring.CompaninVTR.Repository.DiciplinaRepository;
import com.estudo.java.spring.CompaninVTR.Repository.ProfessorRepository;
import com.estudo.java.spring.CompaninVTR.exception.ProfessorExceptions;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        var diciplinasExistente = dcrepository.findByNomeDescricaoIsAtivoTrue(String.valueOf(dto.diciplinas()))
                .orElseThrow(() -> new RuntimeException("Diciplina não existente na base de dados: " + dto.diciplinas()));

        Professor professor = new Professor();
        professor.setNome(dto.nome());
        professor.setIdade(dto.idade());
        Diciplina diciplinas = dcrepository.findByNomeDescricaoIsAtivoTrue(String.valueOf(dto.diciplinas()))
                .orElseThrow(() -> new RuntimeException("Diciplina não existente na base de dados: " + dto.diciplinas()));

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
        return null;
    }

    @Override
    public String delete(String id) {
        return "";
    }

    @Override
    public ProfessorResponseDTO getById(String id) {
        return null;
    }

    @Override
    public List<ProfessorResponseDTO> getAll() { return repository.findByIsAtivoTrue().stream().map(ProfessorResponseDTO::new).toList(); }
}