package com.api.conectaProfessorAluno.dto;


import java.util.List;
import java.util.UUID;

public record AlunoDto(UUID id, String nome, List<AgendaDto> agendas) {
    @Override
    public UUID id() {
        return id;
    }

    @Override
    public String nome() {
        return nome;
    }

    @Override
    public List<AgendaDto> agendas() {
        return agendas;
    }
}
