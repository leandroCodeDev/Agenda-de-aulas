package com.api.conectaProfessorAluno.entitys;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "agenda")
public class AgendaEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "varchar(255) not null")
    private String nome;

    @Column(columnDefinition = "varchar(255) not null")
    private String status;

    @Column(columnDefinition = "varchar(255) not null")
    private String tema;

    @Column(columnDefinition = "varchar(510) not null")
    private String descricao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_aluna", columnDefinition = "TIMESTAMP")
    private Date dataAula;

    @JsonIgnoreProperties("aluno")
    @ManyToOne(optional = false)
    @JoinColumn(name = "idAluno", nullable = false)
    private AlunoEntity aluno;

    @JsonIgnoreProperties("tutor")
    @ManyToOne(optional = false)
    @JoinColumn(name = "idTutor", nullable = false)
    private TutorEntity tutor;

    @JsonIgnoreProperties("material")
    @OneToMany(mappedBy = "agenda", cascade = CascadeType.REMOVE)
    private List<MaterialEntity> material;


}
