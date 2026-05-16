package com.estudo.java.spring.CompaninVTR.Model;

import com.estudo.java.spring.CompaninVTR.Repository.IEntityRepository;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "diciplina")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Diciplina implements IEntityModel {

    private String nomeDiciplina;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = true)//"nulllable" e se a sua regra de negocio possa ter um campo null
    private Professor professor;

    @OneToMany
    @JoinColumn(name = "aluno_id", nullable = true)//"nulllable" e se a sua regra de negocio possa ter um campo null
    private List<Aluno> aluno;

    @CreationTimestamp
    private Instant createdDiciplina = Instant.now();

    @UpdateTimestamp
    private Instant uptatedDiciplina = Instant.now();

    @Override
    public boolean inativar() {
        return false;
    }

    @Override
    public boolean ativar() {
        return false;
    }
}
