package com.api.conectaProfessorAluno.dto;


import java.util.UUID;

public record TutorDto(UUID id, String nome, String especialidade) {
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
}
