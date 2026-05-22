package com.estudo.java.spring.CompaninVTR.Controller.UsersController;

import com.estudo.java.spring.CompaninVTR.DTO.AlunoDTO.AlunoRequestDTO;
import com.estudo.java.spring.CompaninVTR.DTO.AlunoDTO.AlunoResponseDTO;
import com.estudo.java.spring.CompaninVTR.Service.AlunoService.IAlunoService;
import com.estudo.java.spring.CompaninVTR.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController extends AbstractUserController<AlunoRequestDTO, AlunoResponseDTO> {

    public AlunoController(
            @Qualifier("alunoService")
            IUserService<AlunoRequestDTO, AlunoResponseDTO> service
    ) {
        super(service);
    }

}
