package com.estudo.java.spring.CompaninVTR.Model.Diciplina;

import com.estudo.java.spring.CompaninVTR.Model.AbstractEntityModel;
import com.estudo.java.spring.CompaninVTR.Model.Users.Aluno;
import com.estudo.java.spring.CompaninVTR.Model.Users.Professor;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "diciplina")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Diciplina extends AbstractEntityModel {

    private String nomeDiciplina;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = true)//"nulllable" e se a sua regra de negocio possa ter um campo null
    private Professor professor;

    @OneToMany
    @JoinColumn(name = "aluno_id", nullable = true)//"nulllable" e se a sua regra de negocio possa ter um campo null
    private List<Aluno> aluno;
}
