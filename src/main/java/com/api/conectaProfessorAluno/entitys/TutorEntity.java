package com.api.conectaProfessorAluno.entitys;

import com.api.conectaProfessorAluno.dto.AgendaDto;
import com.api.conectaProfessorAluno.dto.TutorDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "tutor")
public class TutorEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "varchar(255) not null")
    private String nome;

    @Column(columnDefinition = "varchar(255) not null")
    private String especialidade;


    @JsonIgnoreProperties("agendas")
    @OneToMany(mappedBy = "tutor", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<AgendaEntity> agendas;

    public TutorEntity(){}

    public TutorEntity(UUID id, String nome, String especialidade) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public TutorEntity(UUID id, String nome, String especialidade, List<AgendaEntity> agendas) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
        this.agendas = agendas;
    }

    public TutorEntity(UUID id, TutorDto tutor) {
        this.id = id;
        this.nome = tutor.nome();
        this.especialidade = tutor.especialidade();
    }

    public TutorEntity(UUID id, TutorDto tutor, List<AgendaEntity> agendas) {
        this.id = id;
        this.nome = tutor.nome();
        this.especialidade = tutor.especialidade();
        this.agendas = agendas;
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

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public List<AgendaEntity> getAgendas() {
        return agendas;
    }

    public void setAgendas(List<AgendaEntity> agendas) {
        this.agendas = agendas;
    }

    public TutorDto toDto() {

        List<AgendaDto> agendaDtos = new ArrayList<>();
        if (agendas != null) {
            agendaDtos = agendas.stream()
                    .map(this::mapToAgendaDto)
                    .collect(Collectors.toList());
        }

        return new TutorDto(this.id,
                this.nome,
                this.especialidade,
                agendaDtos);
    }

    private AgendaDto mapToAgendaDto(AgendaEntity agenda) {

        return agenda.toDtoCustomTutor();
    }

    public TutorDto toDtoCustom() {
        return new TutorDto(this.id,
                this.nome,
                this.especialidade,
                null);
    }
}
