package com.api.conectaProfessorAluno.services.impl;

import com.api.conectaProfessorAluno.dto.AlunoDto;
import com.api.conectaProfessorAluno.entitys.AlunoEntity;
import com.api.conectaProfessorAluno.repositories.AlunoRepository;
import com.api.conectaProfessorAluno.services.AlunoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoServiceImpl(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public AlunoDto create(AlunoDto aluno) {
        AlunoEntity alunoEntity = new AlunoEntity();
        BeanUtils.copyProperties(aluno,alunoEntity);
        alunoEntity = alunoRepository.save(alunoEntity);
        return alunoEntity.toDto();
    }

    @Override
    public AlunoDto update(UUID idAluno,AlunoDto aluno) {
        alunoRepository.findById(idAluno).orElseThrow(() -> new RuntimeException("Objeto não enocntrado"));
        AlunoEntity alunoEntity = alunoRepository.save(new AlunoEntity(idAluno, aluno));
        return alunoEntity.toDto();
    }

    @Override
    public void delete(UUID idAluno) {
        AlunoEntity aluno = alunoRepository.findById(idAluno).orElseThrow(() -> new RuntimeException("Objeto não enocntrado"));
        alunoRepository.delete(aluno);
    }

    @Override
    public AlunoDto getAluno(UUID idAluno) {
        AlunoEntity aluno = alunoRepository.findById(idAluno).orElseThrow(() -> new RuntimeException("Objeto não enocntrado"));
        return aluno.toDto();
    }

    @Override
    public List<AlunoDto> getAlunos() {
        return alunoRepository.findAll().stream()
                .map(alunoEntity -> alunoEntity.toDto())
                .collect(Collectors.toList());
    }
}
