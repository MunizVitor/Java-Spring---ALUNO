package com.estudo.java.spring.CompaninVTR.Service.Diciplina;

import com.estudo.java.spring.CompaninVTR.DTO.DiciplinaDTO.DiciplinaRequestDTO;
import com.estudo.java.spring.CompaninVTR.DTO.DiciplinaDTO.DiciplinaResponseDTO;

import java.util.List;
import java.util.UUID;

public interface IDiciplinaService<REQUEST, RESPONSE> {
    RESPONSE save(REQUEST dto);
    List<RESPONSE> getAllDiciplina();
    RESPONSE getDiciplinaById(String id);
    List<RESPONSE> getDiciplinaByNome(String nomeDiciplina);
    RESPONSE updateDiciplina(String id, REQUEST dto);
    RESPONSE delete(String id);
}
