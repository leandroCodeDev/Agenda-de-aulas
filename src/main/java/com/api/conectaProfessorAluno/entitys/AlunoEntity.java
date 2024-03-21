package com.api.conectaProfessorAluno.entitys;

import com.api.conectaProfessorAluno.dto.AgendaDto;
import com.api.conectaProfessorAluno.dto.AlunoDto;
import com.api.conectaProfessorAluno.dto.TutorDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "aluno")
public class AlunoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(columnDefinition = "varchar(255) not null")
    private String nome;

    @JsonIgnoreProperties("agendas")
    @OneToMany(mappedBy = "aluno", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<AgendaEntity> agendas;


    public AlunoEntity() {}

    public AlunoEntity(UUID id, String nome, List<AgendaEntity> agenda) {
        this.id = id;
        this.nome = nome;
        this.agendas = agenda;
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
        this.agendas = agenda;
    }

    public AlunoEntity(UUID id,AlunoDto aluno) {
        this.id = id;
        this.nome = aluno.nome();
    }

    public AlunoEntity(UUID id,AlunoDto aluno, List<AgendaEntity> agenda) {
        this.id = id;
        this.nome = aluno.nome();
        this.agendas = agenda;
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

    public List<AgendaEntity> getAgendas() {
        return agendas;
    }

    public void setAgendas(List<AgendaEntity> agendas) {
        this.agendas = agendas;
    }


    public AlunoDto toDto() {
        List<AgendaDto> agendaDtos = new ArrayList<>();
        if (agendas != null) {
            agendaDtos = agendas.stream()
                    .map(this::mapToAgendaDto)
                    .collect(Collectors.toList());
        }
        return new AlunoDto(getId(),getNome(),agendaDtos);
    }

    private AgendaDto mapToAgendaDto(AgendaEntity agenda) {

        return agenda.toDtoCustomAluno();
    }

    public AlunoDto toDtoCustom() {
        return new AlunoDto(getId(),getNome(),null);
    }
}
