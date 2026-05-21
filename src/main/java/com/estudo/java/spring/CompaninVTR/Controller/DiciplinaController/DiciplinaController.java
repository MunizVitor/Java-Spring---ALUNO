package com.estudo.java.spring.CompaninVTR.Controller.DiciplinaController;

import com.estudo.java.spring.CompaninVTR.DTO.DiciplinaDTO.DiciplinaRequestDTO;
import com.estudo.java.spring.CompaninVTR.DTO.DiciplinaDTO.DiciplinaResponseDTO;
import com.estudo.java.spring.CompaninVTR.Service.Diciplina.IDiciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/diciplinas")
public class DiciplinaController extends AbstractDiciplinaController<DiciplinaRequestDTO, DiciplinaResponseDTO> {

    @Autowired
    IDiciplinaService service;

    public DiciplinaController(IDiciplinaService service){
        super(service);
    }
}
