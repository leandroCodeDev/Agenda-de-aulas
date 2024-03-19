package com.api.conectaProfessorAluno.entitys;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "aluno")
public class AlunoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "varchar(255) not null")
    private String nome;

    @JsonIgnoreProperties("aluno")
    @OneToMany(mappedBy = "aluno", cascade = CascadeType.REMOVE)
    private List<AgendaEntity> agenda;

}
