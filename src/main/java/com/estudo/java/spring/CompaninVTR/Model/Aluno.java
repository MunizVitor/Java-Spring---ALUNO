package com.estudo.java.spring.CompaninVTR.Model;

import com.estudo.java.spring.CompaninVTR.DTO.AlunoDTO.AlunoPostDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "aluno")
public class Aluno extends Pessoa{

    @ManyToOne
    @JoinColumn(name = "diciplina_id", nullable = false)
    private Diciplina diciplina;

}
