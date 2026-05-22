package com.estudo.java.spring.CompaninVTR.Controller.DiciplinaController;

import com.estudo.java.spring.CompaninVTR.DTO.DiciplinaDTO.DiciplinaRequestDTO;
import com.estudo.java.spring.CompaninVTR.DTO.DiciplinaDTO.DiciplinaResponseDTO;
import com.estudo.java.spring.CompaninVTR.Service.Diciplina.DiciplinaService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping("/diciplinas")
public class AbstractDiciplinaController {

    @Autowired
    private DiciplinaService service;

    @PostMapping
    public ResponseEntity<DiciplinaResponseDTO> save(@RequestBody DiciplinaRequestDTO dto) {

        DiciplinaResponseDTO response = service.save(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<DiciplinaResponseDTO>> getAll() {

        List<DiciplinaResponseDTO> response = service.getAllDiciplina();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{nomeDiciplina}")
    public ResponseEntity<List<DiciplinaResponseDTO>> getByName(
            @PathVariable String nomeDiciplina) {

        List<DiciplinaResponseDTO> response =
                service.getDiciplinaByNome(nomeDiciplina);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<DiciplinaResponseDTO> getById(
            @PathVariable String id) {

        DiciplinaResponseDTO response =
                service.getDiciplinaById(id);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiciplinaResponseDTO> update(
            @PathVariable String id,
            @RequestBody DiciplinaRequestDTO dto) {

        DiciplinaResponseDTO response =
                service.updateDiciplina(id, dto);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DiciplinaResponseDTO> delete(
            @PathVariable String id) {

        DiciplinaResponseDTO response =
                service.delete(id);

        return ResponseEntity.ok(response);
    }
}