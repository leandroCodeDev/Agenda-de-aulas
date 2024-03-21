package com.api.conectaProfessorAluno.dto;


import java.util.Date;
import java.util.List;
import java.util.UUID;

public record AgendaDto(UUID id, String nome, String status, String tema, String descricao, Date dataAula, TutorDto tutor,AlunoDto  aluno) {
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
    public TutorDto tutor() {
        return tutor;
    }

    @Override
    public AlunoDto aluno() {
        return aluno;
    }
}
