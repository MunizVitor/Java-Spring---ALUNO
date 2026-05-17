package com.estudo.java.spring.CompaninVTR.Repository;

import com.estudo.java.spring.CompaninVTR.Model.Diciplina;
import com.estudo.java.spring.CompaninVTR.Model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DiciplinaRepository extends IEntityRepository<Diciplina> {

    Optional<Diciplina> findByNomeDescricaoIsAtivoTrue(String diciplina);
}
