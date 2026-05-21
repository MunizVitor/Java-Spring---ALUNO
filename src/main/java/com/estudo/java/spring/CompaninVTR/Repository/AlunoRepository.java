package com.estudo.java.spring.CompaninVTR.Repository;

import com.estudo.java.spring.CompaninVTR.Model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AlunoRepository extends IEntityRepository<Aluno> {
    Optional<Aluno> findByNomeAndIsAtivoTrue(String nome);
}
