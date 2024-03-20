package com.api.conectaProfessorAluno.dto;


import java.util.UUID;

public record AlunoDto(UUID id, String nome) {
    @Override
    public UUID id() {
        return id;
    }

    @Override
    public String nome() {
        return nome;
    }
}
