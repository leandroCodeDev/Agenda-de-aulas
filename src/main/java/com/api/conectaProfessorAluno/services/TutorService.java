package com.api.conectaProfessorAluno.services;

import com.api.conectaProfessorAluno.dto.TutorDto;
import com.api.conectaProfessorAluno.entitys.TutorEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public interface TutorService {
    public TutorDto create(TutorDto tutor);
    public TutorDto update(UUID idTutor,TutorDto tutor);


    public void delete(UUID idTutor);
    public TutorDto getTutor(UUID idTutor);
    public List<TutorDto> getTutores();

    public TutorEntity getTutorEntity(UUID idTutor);

}
