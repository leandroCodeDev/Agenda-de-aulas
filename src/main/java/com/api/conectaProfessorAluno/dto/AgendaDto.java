package com.api.conectaProfessorAluno.dto;


import java.util.Date;
import java.util.UUID;

public record AgendaDto(UUID id, String nome, String status, String tema, String descricao, Date dataAula, UUID idTutor,UUID idAluno) {
    @Override
    public UUID id() {
        return id;
    }

    @Override
    public String nome() {
        return nome;
    }

    @Override
    public String status() {
        return status;
    }

    @Override
    public String tema() {
        return tema;
    }

    @Override
    public String descricao() {
        return descricao;
    }

    @Override
    public Date dataAula() {
        return dataAula;
    }

    @Override
    public UUID idTutor() {
        return idTutor;
    }

    @Override
    public UUID idAluno() {
        return idAluno;
    }
}
