package com.api.conectaProfessorAluno.entitys;

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

}
