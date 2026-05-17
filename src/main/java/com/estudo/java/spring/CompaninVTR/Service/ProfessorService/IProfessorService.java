package com.estudo.java.spring.CompaninVTR.Service.ProfessorService;

import com.estudo.java.spring.CompaninVTR.DTO.ProfessorDTO.ProfessorRequestDTO;
import com.estudo.java.spring.CompaninVTR.DTO.ProfessorDTO.ProfessorResponseDTO;
import com.estudo.java.spring.CompaninVTR.Service.IUserService;
import com.estudo.java.spring.CompaninVTR.exception.ProfessorExceptions;

public interface IProfessorService extends IUserService<ProfessorRequestDTO, ProfessorResponseDTO> {
    public ProfessorResponseDTO save(ProfessorRequestDTO dto) throws ProfessorExceptions;

    public ProfessorResponseDTO update(String id, ProfessorRequestDTO dto) throws ProfessorExceptions;

    public String delete(String id);

    public ProfessorResponseDTO getById(String id);

}
