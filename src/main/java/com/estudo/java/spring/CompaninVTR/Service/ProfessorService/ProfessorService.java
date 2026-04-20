package com.estudo.java.spring.CompaninVTR.Service.ProfessorService;

import com.estudo.java.spring.CompaninVTR.DTO.ProfessorDTO.ProfessorGetDTO;
import com.estudo.java.spring.CompaninVTR.DTO.ProfessorDTO.ProfessorPostDTO;
import com.estudo.java.spring.CompaninVTR.Model.Diciplina;
import com.estudo.java.spring.CompaninVTR.Model.Professor;
import com.estudo.java.spring.CompaninVTR.Repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository pfRepository;

    public ProfessorGetDTO createProfessor(ProfessorPostDTO dto){
        Professor professor = new Professor();
        professor.setNome(dto.nome());
        professor.setIdade(dto.idade());

        List<Diciplina> disciplinas = Optional.ofNullable(dto.disciplinas())
                .orElse(List.of()) // se for null, usa lista vazia
                .stream()
                .map(nome -> {
                    Diciplina d = new Diciplina();
                    d.setNome(nome);
                    d.setProfessor(professor);
                    return d;
                }).toList();

        professor.setDiciplina(disciplinas);
        pfRepository.save(professor);

        return new ProfessorGetDTO(professor);
    }
}
