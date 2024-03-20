package com.api.conectaProfessorAluno.entitys;

import com.api.conectaProfessorAluno.dto.AlunoDto;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(columnDefinition = "varchar(255) not null")
    private String nome;

    @JsonIgnoreProperties("aluno")
    @OneToMany(mappedBy = "aluno", cascade = CascadeType.REMOVE)
    private List<AgendaEntity> agenda;


    public AlunoEntity() {}

    public AlunoEntity(UUID id, String nome, List<AgendaEntity> agenda) {
        this.id = id;
        this.nome = nome;
        this.agenda = agenda;
    }

    public AlunoEntity(UUID id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public AlunoEntity(String nome) {
        this.nome = nome;
    }
    public AlunoEntity(AlunoDto aluno) {
        this.id = aluno.id();
        this.nome = aluno.nome();
    }

    public AlunoEntity(AlunoDto aluno, List<AgendaEntity> agenda) {
        this.id = aluno.id();
        this.nome = aluno.nome();
        this.agenda = agenda;
    }

    public AlunoEntity(UUID id,AlunoDto aluno) {
        this.id = id;
        this.nome = aluno.nome();
    }

    public AlunoEntity(UUID id,AlunoDto aluno, List<AgendaEntity> agenda) {
        this.id = id;
        this.nome = aluno.nome();
        this.agenda = agenda;
    }



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<AgendaEntity> getAgenda() {
        return agenda;
    }

    public void setAgenda(List<AgendaEntity> agenda) {
        this.agenda = agenda;
    }


    public AlunoDto toDto() {
        return new AlunoDto(getId(),getNome());
    }
}
