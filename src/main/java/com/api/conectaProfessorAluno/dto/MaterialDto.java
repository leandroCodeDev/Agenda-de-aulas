package com.api.conectaProfessorAluno.dto;


import com.api.conectaProfessorAluno.entitys.AgendaEntity;

import java.util.Date;
import java.util.UUID;

public record MaterialDto(UUID id, String caminhoArquivo, String urlArquivo, AgendaDto agenda) { }
