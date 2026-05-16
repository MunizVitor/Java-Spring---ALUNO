package com.estudo.java.spring.CompaninVTR.Service.AlunoService;

import com.estudo.java.spring.CompaninVTR.DTO.AlunoDTO.AlunoRequestDTO;
import com.estudo.java.spring.CompaninVTR.DTO.AlunoDTO.AlunoResponseDTO;
import com.estudo.java.spring.CompaninVTR.Repository.IEntityRepository;
import com.estudo.java.spring.CompaninVTR.exception.AlunoExceptions;
import org.springframework.beans.factory.annotation.Autowired;

public interface IAlunoService {
    public AlunoResponseDTO save(AlunoRequestDTO dto) throws AlunoExceptions;

    public AlunoResponseDTO update(AlunoRequestDTO dto) throws AlunoExceptions;

    public String delete(String id);

    public AlunoResponseDTO getById(String id);

}
