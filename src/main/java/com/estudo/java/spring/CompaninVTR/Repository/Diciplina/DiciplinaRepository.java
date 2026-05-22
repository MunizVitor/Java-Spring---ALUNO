package com.estudo.java.spring.CompaninVTR.Repository.Diciplina;

import com.estudo.java.spring.CompaninVTR.Model.Diciplina.Diciplina;
import com.estudo.java.spring.CompaninVTR.Repository.IEntityRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DiciplinaRepository extends IEntityRepository<Diciplina> {

    List<Diciplina> findByNomeDiciplinaAndIsAtivoTrue(String nomeDiciplina);
}
