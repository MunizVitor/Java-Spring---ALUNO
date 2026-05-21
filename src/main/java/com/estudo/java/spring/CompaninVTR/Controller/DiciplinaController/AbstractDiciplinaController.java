package com.estudo.java.spring.CompaninVTR.Controller.DiciplinaController;

import com.estudo.java.spring.CompaninVTR.Service.Diciplina.IDiciplinaService;
import com.estudo.java.spring.CompaninVTR.Service.IUserService;
import com.estudo.java.spring.CompaninVTR.exception.AlunoExceptions;
import com.estudo.java.spring.CompaninVTR.exception.ProfessorExceptions;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
public class AbstractDiciplinaController<REQUEST, RESPONSE> {

    @Autowired
    protected IDiciplinaService<REQUEST, RESPONSE> service;

    @PostMapping
    public ResponseEntity<RESPONSE> save(@RequestBody REQUEST dto) {
        RESPONSE response = service.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("id")
    public ResponseEntity<RESPONSE> getById(@PathVariable(value = "id") String id) {
        RESPONSE response = service.getById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @GetMapping
    public ResponseEntity<List<RESPONSE>> getAll() {
        List<RESPONSE> response = Collections.singletonList(service.getAll());
        return ResponseEntity.ok(response);
    }
}
