package com.estudo.java.spring.CompaninVTR.Repository;

import com.estudo.java.spring.CompaninVTR.Model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProfessorRepository extends IEntityRepository<Professor> {

    Optional<Professor> findByNomeAndIsAtivoTrue(String nome);

}
