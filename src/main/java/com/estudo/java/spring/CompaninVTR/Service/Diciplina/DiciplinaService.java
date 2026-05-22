package com.estudo.java.spring.CompaninVTR.Service.Diciplina;

import com.estudo.java.spring.CompaninVTR.DTO.DiciplinaDTO.DiciplinaRequestDTO;
import com.estudo.java.spring.CompaninVTR.DTO.DiciplinaDTO.DiciplinaResponseDTO;
import com.estudo.java.spring.CompaninVTR.Model.Users.Aluno;
import com.estudo.java.spring.CompaninVTR.Model.Diciplina.Diciplina;
import com.estudo.java.spring.CompaninVTR.Model.Users.Professor;
import com.estudo.java.spring.CompaninVTR.Repository.Users.AlunoRepository;
import com.estudo.java.spring.CompaninVTR.Repository.Diciplina.DiciplinaRepository;
import com.estudo.java.spring.CompaninVTR.Repository.Users.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DiciplinaService implements IDiciplinaService<DiciplinaRequestDTO, DiciplinaResponseDTO> {

    @Autowired
    private DiciplinaRepository dcRepository;

    @Autowired
    private ProfessorRepository pfRepository;

    @Autowired
    private AlunoRepository alRepository;

    @Override
    public DiciplinaResponseDTO save(DiciplinaRequestDTO dto) {
        // valida professor
        Professor professor = pfRepository.findByNomeAndIsAtivoTrue(dto.professor())
                .orElseThrow(() -> new RuntimeException("Professor não encontrado ou inativo: " + dto.professor()));

        // cria disciplina
        Diciplina diciplina = new Diciplina();
        diciplina.setNomeDiciplina(dto.nomeDiciplina());
        diciplina.setProfessor(professor);

        // valida alunos
        List<Aluno> alunosValidados = Optional.ofNullable(dto.aluno())
                .orElse(List.of()) // se for null, usa lista vazia
                .stream()
                .map(nomeAluno -> alRepository.findByNomeAndIsAtivoTrue(String.valueOf(nomeAluno))
                        .orElseThrow(() -> new RuntimeException("Aluno não encontrado ou inativo: " + nomeAluno)))
                .toList();

        diciplina.setAlunos(alunosValidados);
        dcRepository.save(diciplina);

        return new DiciplinaResponseDTO(diciplina);
    }

    @Override
    public List<DiciplinaResponseDTO> getAllDiciplina() {
        return dcRepository.findAll()
                .stream()
                .map(DiciplinaResponseDTO::new)
                .toList();
    }

    @Override
    public DiciplinaResponseDTO getDiciplinaById(String id) {
        Diciplina diciplina = dcRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada: " + id));
        return new DiciplinaResponseDTO(diciplina);
    }

    @Override
    public List<DiciplinaResponseDTO> getDiciplinaByNome(String nomeDiciplina) {
        return dcRepository.findByNomeDiciplinaAndIsAtivoTrue(nomeDiciplina)
                .stream()
                .map(DiciplinaResponseDTO::new)
                .toList();
    }

    @Override
    public DiciplinaResponseDTO updateDiciplina(String id, DiciplinaRequestDTO dto) {
        Diciplina diciplina = dcRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada: " + id));
        diciplina.setNomeDiciplina(dto.nomeDiciplina());
        Professor professor = pfRepository.findByNomeAndIsAtivoTrue(dto.professor())
                .orElseThrow(() -> new RuntimeException("Professor não encontrado ou inativo: " + dto.professor()));
        diciplina.setProfessor(professor);

        List<Aluno> alunosValidados = Optional.ofNullable(dto.aluno())
                .orElse(List.of())
                .stream()
                .map(nomeAluno -> alRepository.findByNomeAndIsAtivoTrue(String.valueOf(nomeAluno))
                        .orElseThrow(() -> new RuntimeException("Aluno não encontrado ou inativo: " + nomeAluno)))
                .toList();
        diciplina.setAlunos(alunosValidados);
        dcRepository.save(diciplina);

        return new DiciplinaResponseDTO(diciplina);
    }

    @Override
    public DiciplinaResponseDTO delete(String id) {
        return null;
    }



}
