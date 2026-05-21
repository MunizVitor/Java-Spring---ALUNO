package com.estudo.java.spring.CompaninVTR.Service.Diciplina;

import com.estudo.java.spring.CompaninVTR.DTO.DiciplinaDTO.DiciplinaRequestDTO;
import com.estudo.java.spring.CompaninVTR.DTO.DiciplinaDTO.DiciplinaResponseDTO;
import com.estudo.java.spring.CompaninVTR.Model.Aluno;
import com.estudo.java.spring.CompaninVTR.Model.Diciplina;
import com.estudo.java.spring.CompaninVTR.Model.Professor;
import com.estudo.java.spring.CompaninVTR.Repository.AlunoRepository;
import com.estudo.java.spring.CompaninVTR.Repository.DiciplinaRepository;
import com.estudo.java.spring.CompaninVTR.Repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DiciplinaService {

    @Autowired
    private DiciplinaRepository dcRepository;

    @Autowired
    private ProfessorRepository pfRepository;

    @Autowired
    private AlunoRepository alRepository;

    public DiciplinaResponseDTO createDiciplina(DiciplinaRequestDTO dto) {
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

        diciplina.setAluno(alunosValidados);
        dcRepository.save(diciplina);

        return new DiciplinaResponseDTO(diciplina);
    }

    public List<DiciplinaResponseDTO> getAllDiciplina() {
        return dcRepository.findAll()
                .stream()
                .map(DiciplinaResponseDTO::new)
                .toList();
    }

    public DiciplinaResponseDTO getDiciplinaById(UUID id) {
        Diciplina diciplina = dcRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada: " + id));
        return new DiciplinaResponseDTO(diciplina);
    }

    public List<DiciplinaResponseDTO> getDiciplinaByNome(String nomeDiciplina) {
        return dcRepository.findByNomeDescricaoIsAtivoTrue(nomeDiciplina)
                .stream()
                .map(DiciplinaResponseDTO::new)
                .toList();
    }


    public DiciplinaResponseDTO updateDiciplina(UUID id, DiciplinaRequestDTO dto) {
        Diciplina diciplina = dcRepository.findById(id)
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
        diciplina.setAluno(alunosValidados);
        dcRepository.save(diciplina);

        return new DiciplinaResponseDTO(diciplina);
    }



}
