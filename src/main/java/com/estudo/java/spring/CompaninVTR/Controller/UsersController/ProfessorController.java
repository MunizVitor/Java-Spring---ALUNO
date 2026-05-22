package com.estudo.java.spring.CompaninVTR.Controller.UsersController;

import com.estudo.java.spring.CompaninVTR.DTO.AlunoDTO.AlunoRequestDTO;
import com.estudo.java.spring.CompaninVTR.DTO.AlunoDTO.AlunoResponseDTO;
import com.estudo.java.spring.CompaninVTR.DTO.ProfessorDTO.ProfessorRequestDTO;
import com.estudo.java.spring.CompaninVTR.DTO.ProfessorDTO.ProfessorResponseDTO;
import com.estudo.java.spring.CompaninVTR.Service.IUserService;
import com.estudo.java.spring.CompaninVTR.Service.ProfessorService.IProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/professores")
public class ProfessorController extends AbstractUserController {
    public ProfessorController(
            @Qualifier("professorService")
            IUserService<ProfessorRequestDTO, ProfessorResponseDTO> service
    ) {
        super(service);
    }
}
