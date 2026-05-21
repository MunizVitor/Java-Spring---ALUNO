package com.estudo.java.spring.CompaninVTR.Service.Diciplina;

import com.estudo.java.spring.CompaninVTR.DTO.DiciplinaDTO.DiciplinaRequestDTO;
import com.estudo.java.spring.CompaninVTR.DTO.DiciplinaDTO.DiciplinaResponseDTO;
import com.estudo.java.spring.CompaninVTR.Model.Diciplina;

public interface IDiciplinaService<REQUEST, RESPONSE> {
    public RESPONSE save(REQUEST dto);
    public RESPONSE update(String id);
    public RESPONSE getById(String id);
    public RESPONSE delete(String id);
    public RESPONSE getAll();

}
