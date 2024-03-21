package com.api.conectaProfessorAluno.services.impl;

import com.api.conectaProfessorAluno.dto.TutorDto;
import com.api.conectaProfessorAluno.entitys.TutorEntity;
import com.api.conectaProfessorAluno.exceptions.errors.BadRequestException;
import com.api.conectaProfessorAluno.helpers.BeansHelper;
import com.api.conectaProfessorAluno.repositories.TutorRepository;
import com.api.conectaProfessorAluno.services.TutorService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TutorServiceImpl implements TutorService {

    private final TutorRepository tutorRepository;

    public TutorServiceImpl(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    @Override
    public TutorDto create(TutorDto tutor) {
        TutorEntity tutorEntity = new TutorEntity();
        BeanUtils.copyProperties(tutor,tutorEntity);
        tutorEntity = tutorRepository.save(tutorEntity);
        return tutorEntity.toDto();
    }

    @Override
    public TutorDto update(UUID idTutor,TutorDto tutor) {
        TutorEntity tutorEntity = tutorRepository.findById(idTutor).orElseThrow(() -> new BadRequestException("Tutor não enocntrado"));
        BeansHelper.copyNonNullProperties(tutor,tutorEntity);
        tutorRepository.save(tutorEntity);
        return tutorEntity.toDto();
    }

    @Override
    public void delete(UUID idTutor) {
        TutorEntity tutor = tutorRepository.findById(idTutor).orElseThrow(() -> new BadRequestException("Tutor não enocntrado"));
        tutorRepository.delete(tutor);
    }

    @Override
    public TutorDto getTutor(UUID idTutor) {
        TutorEntity tutor = tutorRepository.findById(idTutor).orElseThrow(() -> new BadRequestException("Tutor não enocntrado"));
        return tutor.toDto();
    }


    @Override
    public TutorEntity getTutorEntity(UUID idTutor) {
        return tutorRepository.findById(idTutor).orElseThrow(() -> new BadRequestException("Tutor não enocntrado"));
    }

    @Override
    public List<TutorDto> getTutores() {
        return tutorRepository.findAll().stream()
                .map(TutorEntity::toDto)
                .collect(Collectors.toList());
    }

}
