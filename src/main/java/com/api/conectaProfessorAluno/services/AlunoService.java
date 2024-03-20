package com.api.conectaProfessorAluno.services;

import com.api.conectaProfessorAluno.dto.AlunoDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public interface AlunoService {
    public AlunoDto create(AlunoDto aluno);
    public AlunoDto update(UUID idAluno,AlunoDto aluno);


    public void delete(UUID idAluno);
    public AlunoDto getAluno(UUID idAluno);
    public List<AlunoDto> getAlunos();
}
