package com.estudo.java.spring.CompaninVTR.Repository;

import com.estudo.java.spring.CompaninVTR.Model.AbstractEntityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IEntityRepository<T extends AbstractEntityModel> extends JpaRepository<T, UUID> {

    //para pegar apenas os que estao como ativo e nao inativado
    List<T> findByIsAtivoTrue();

    //para pegar apenas o que estamos passando o id para ser inativo ou ativo
    Optional<T> findByIdAndIsAtivoTrue(UUID id);
}
