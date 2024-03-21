package com.api.conectaProfessorAluno.dto;


import java.util.List;
import java.util.UUID;

public record TutorDto(UUID id, String nome, String especialidade, List<AgendaDto> agendas) {
    @Override
    public UUID id() {
        return id;
    }

    @Override
    public String nome() {
        return nome;
    }

    @Override
    public String especialidade() {
        return especialidade;
    }

    @Override
    public List<AgendaDto> agendas() {
        return agendas;
    }
}
