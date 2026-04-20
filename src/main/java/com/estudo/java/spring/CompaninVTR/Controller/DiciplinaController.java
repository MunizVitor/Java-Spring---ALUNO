package com.estudo.java.spring.CompaninVTR.Controller;

import com.estudo.java.spring.CompaninVTR.DTO.DiciplinaController.DiciplinaGetDTO;
import com.estudo.java.spring.CompaninVTR.DTO.DiciplinaController.DiciplinaPostDTO;
import com.estudo.java.spring.CompaninVTR.Service.Diciplina.DiciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/diciplinas")
public class DiciplinaController {

    @Autowired
    private DiciplinaService dcService;

    @PostMapping
    public ResponseEntity<DiciplinaGetDTO> createDiciplina(@RequestBody DiciplinaPostDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(dcService.createDiciplina(dto));
    }

    @GetMapping
    public ResponseEntity getAllDiciplina(){
        return ResponseEntity.status(HttpStatus.OK).body(dcService.getAllDiciplina());
    }
}
