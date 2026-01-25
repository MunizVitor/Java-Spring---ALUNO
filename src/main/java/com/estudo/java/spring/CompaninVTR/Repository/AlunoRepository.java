package com.estudo.java.spring.CompaninVTR.Repository;

import com.estudo.java.spring.CompaninVTR.Model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AlunoRepository extends JpaRepository<Aluno, UUID> {

    //para pegar apenas os que estao como ativo e nao inativado
    List<Aluno> findByIsAtivo(boolean isAtivo);

    //para pegar apenas o que estamos passando o id para ser inativo ou atiivo
    Optional<Aluno> findByIdAndIsAtivoTrue(UUID id);
}
