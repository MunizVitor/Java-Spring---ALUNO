package com.estudo.java.spring.CompaninVTR.Service.ProfessorService;

import com.estudo.java.spring.CompaninVTR.DTO.AlunoDTO.AlunoRequestDTO;
import com.estudo.java.spring.CompaninVTR.DTO.AlunoDTO.AlunoResponseDTO;
import com.estudo.java.spring.CompaninVTR.exception.AlunoExceptions;

public interface IProfessorService {
    public AlunoResponseDTO save(AlunoRequestDTO dto) throws AlunoExceptions;

    public AlunoResponseDTO update(String id, AlunoRequestDTO dto) throws AlunoExceptions;

    public String delete(String id);

    public AlunoResponseDTO getById(String id);

}
