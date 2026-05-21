package com.estudo.java.spring.CompaninVTR.Controller.UsersController;

import com.estudo.java.spring.CompaninVTR.Service.IUserService;
import com.estudo.java.spring.CompaninVTR.exception.AlunoExceptions;
import com.estudo.java.spring.CompaninVTR.exception.ProfessorExceptions;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractUserController<REQUEST, RESPONSE> {

    @Autowired
    protected IUserService<REQUEST, RESPONSE> service;

    @PostMapping
    public ResponseEntity<RESPONSE> save(@RequestBody REQUEST dto) throws AlunoExceptions, ProfessorExceptions {
        RESPONSE response = service.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("id")
    public ResponseEntity<RESPONSE> getById(@PathVariable(value = "id") String id) throws AlunoExceptions, ProfessorExceptions {
        RESPONSE response = service.getById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @GetMapping
    public ResponseEntity<List<RESPONSE>> getAll() throws AlunoExceptions, ProfessorExceptions {
        List<RESPONSE> response = service.getAll();
        return ResponseEntity.ok(response);
    }

}
