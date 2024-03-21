package com.api.conectaProfessorAluno.entitys;

import com.api.conectaProfessorAluno.dto.AgendaDto;
import com.api.conectaProfessorAluno.dto.TutorDto;
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
    @Column(name = "data_aula", columnDefinition = "TIMESTAMP")
    private Date dataAula;

    @JsonIgnoreProperties("aluno")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "idAluno", nullable = false)
    private AlunoEntity aluno;

    @JsonIgnoreProperties("tutor")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "idTutor", nullable = false)
    private TutorEntity tutor;

    @JsonIgnoreProperties("material")
    @OneToMany(mappedBy = "agenda", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<MaterialEntity> material;

    public AgendaEntity() {
    }

    public AgendaEntity(UUID id, String nome, String status, String tema, String descricao, Date dataAula) {
        this.id = id;
        this.nome = nome;
        this.status = status;
        this.tema = tema;
        this.descricao = descricao;
        this.dataAula = dataAula;
    }

    public AgendaEntity(AgendaDto agenda, AlunoEntity aluno, TutorEntity tutor) {
        this.nome = agenda.nome();
        this.status = agenda.status();
        this.tema = agenda.tema();
        this.descricao = agenda.descricao();
        this.dataAula = agenda.dataAula();
        this.aluno = aluno;
        this.tutor = tutor;
    }

    public AgendaEntity(UUID id, AgendaDto agenda, AlunoEntity aluno, TutorEntity tutor) {
        this.id = id;
        this.nome = agenda.nome();
        this.status = agenda.status();
        this.tema = agenda.tema();
        this.descricao = agenda.descricao();
        this.dataAula = agenda.dataAula();
        this.aluno = aluno;
        this.tutor = tutor;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataAula() {
        return dataAula;
    }

    public void setDataAula(Date dataAula) {
        this.dataAula = dataAula;
    }

    public AlunoEntity getAluno() {
        return aluno;
    }

    public void setAluno(AlunoEntity aluno) {
        this.aluno = aluno;
    }

    public TutorEntity getTutor() {
        return tutor;
    }

    public void setTutor(TutorEntity tutor) {
        this.tutor = tutor;
    }

    public List<MaterialEntity> getMaterial() {
        return material;
    }

    public void setMaterial(List<MaterialEntity> material) {
        this.material = material;
    }


    public AgendaDto toDto() {
        return new AgendaDto(
                this.id,
                this.status,
                this.nome,
                this.tema,
                this.descricao,
                this.dataAula,
                this.tutor.toDtoCustom(),
                this.aluno.toDtoCustom()
        );
    }

    public AgendaDto toDtoCustomAluno() {
        return new AgendaDto(
                this.id,
                this.status,
                this.nome,
                this.tema,
                this.descricao,
                this.dataAula,
                this.tutor.toDtoCustom(),
                null
        );
    }

    public AgendaDto toDtoCustomTutor() {
        return new AgendaDto(
                this.id,
                this.status,
                this.nome,
                this.tema,
                this.descricao,
                this.dataAula,
                null,
                this.aluno.toDtoCustom()
        );
    }
}
