package com.estudo.java.spring.CompaninVTR.Service.Diciplina;

import com.estudo.java.spring.CompaninVTR.DTO.DiciplinaController.DiciplinaGetDTO;
import com.estudo.java.spring.CompaninVTR.DTO.DiciplinaController.DiciplinaPostDTO;
import com.estudo.java.spring.CompaninVTR.Model.Diciplina;
import com.estudo.java.spring.CompaninVTR.Repository.DiciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiciplinaService {

    @Autowired
    private DiciplinaRepository dcRepository;

    public DiciplinaGetDTO createDiciplina(DiciplinaPostDTO dto){
        Diciplina diciplina = new Diciplina();
        diciplina.setNome(dto.nome());
        diciplina.setProfessor(dto.professor());

        dcRepository.save(diciplina);

        return new DiciplinaGetDTO(diciplina);
    }

    public List<DiciplinaGetDTO> getAllDiciplina (){
        return dcRepository.findAll()
                .stream()
                .map(DiciplinaGetDTO::new)
                .toList();
    }
}
