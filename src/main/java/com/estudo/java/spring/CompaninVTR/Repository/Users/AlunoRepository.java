package com.estudo.java.spring.CompaninVTR.Repository.Users;

import com.estudo.java.spring.CompaninVTR.Model.Users.Aluno;
import com.estudo.java.spring.CompaninVTR.Repository.IEntityRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends IEntityRepository<Aluno> {
    Optional<Aluno> findByNomeAndIsAtivoTrue(String nome);
}
