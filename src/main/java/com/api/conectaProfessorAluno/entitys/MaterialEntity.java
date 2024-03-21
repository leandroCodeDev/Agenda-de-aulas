package com.api.conectaProfessorAluno.entitys;

import com.api.conectaProfessorAluno.dto.MaterialDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "material")
public class MaterialEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "caminho_arquivo",columnDefinition = "varchar(255)")
    private String caminhoArquivo;

    @Column(name = "url_arquivo", columnDefinition = "varchar(255)")
    private String urlArquivo;

    @JsonIgnoreProperties("agenda")
    @ManyToOne(optional = false)
    @JoinColumn(name = "idAgenda", nullable = false)
    private AgendaEntity agenda;

    public MaterialEntity(){}

    public MaterialEntity(UUID id, String caminhoArquivo, String urlArquivo, AgendaEntity agenda) {
        this.id = id;
        this.caminhoArquivo = caminhoArquivo;
        this.urlArquivo = urlArquivo;
        this.agenda = agenda;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public void setCaminhoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public String getUrlArquivo() {
        return urlArquivo;
    }

    public void setUrlArquivo(String urlArquivo) {
        this.urlArquivo = urlArquivo;
    }

    public AgendaEntity getAgenda() {
        return agenda;
    }

    public void setAgenda(AgendaEntity agenda) {
        this.agenda = agenda;
    }

    public MaterialDto toDto(){
        return new MaterialDto(this.id,
        this.caminhoArquivo,
        this.urlArquivo,
        this.agenda.getId());
    }
}
