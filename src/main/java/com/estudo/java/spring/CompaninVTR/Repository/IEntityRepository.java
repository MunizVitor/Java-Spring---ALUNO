package com.estudo.java.spring.CompaninVTR.Repository;

import com.estudo.java.spring.CompaninVTR.Model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IEntityRepository<T> extends JpaRepository<T, UUID> {

    UserDetails findByLoginAndIsAtivoTrue(String login);

    //para pegar apenas os que estao como ativo e nao inativado
    List<T> findByIsAtivo(boolean isAtivo);

    //para pegar apenas o que estamos passando o id para ser inativo ou atiivo
    Optional<T> findByIdAndIsAtivoTrue(UUID id);
}
