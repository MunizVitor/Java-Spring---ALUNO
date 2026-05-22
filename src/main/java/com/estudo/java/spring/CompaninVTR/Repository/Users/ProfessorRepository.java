package com.estudo.java.spring.CompaninVTR.Repository.Users;

import com.estudo.java.spring.CompaninVTR.Model.Users.Professor;
import com.estudo.java.spring.CompaninVTR.Repository.IEntityRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends IEntityRepository<Professor> {

    Optional<Professor> findByNomeAndIsAtivoTrue(String nome);

}
