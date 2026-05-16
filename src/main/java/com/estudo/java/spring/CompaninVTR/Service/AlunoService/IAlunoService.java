package com.estudo.java.spring.CompaninVTR.Service.AlunoService;

import com.estudo.java.spring.CompaninVTR.DTO.AlunoDTO.AlunoRequestDTO;
import com.estudo.java.spring.CompaninVTR.DTO.AlunoDTO.AlunoResponseDTO;
import com.estudo.java.spring.CompaninVTR.Service.IUserService;
import com.estudo.java.spring.CompaninVTR.exception.AlunoExceptions;

import java.util.List;

public interface IAlunoService extends IUserService<AlunoRequestDTO, AlunoResponseDTO> {
    public List getAll();

    public AlunoResponseDTO save(AlunoRequestDTO dto) throws AlunoExceptions;

    public AlunoResponseDTO update(String id, AlunoRequestDTO dto) throws AlunoExceptions;

    public String delete(String id);

    public AlunoResponseDTO getById(String id);

}
