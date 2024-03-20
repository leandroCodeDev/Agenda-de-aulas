package com.api.conectaProfessorAluno.services;

import com.api.conectaProfessorAluno.dto.TutorDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public interface TutorService {
    public TutorDto create(TutorDto tutor);
    public TutorDto update(UUID idAluno,TutorDto tutor);


    public void delete(UUID idTutor);
    public TutorDto getTutor(UUID idTutor);
    public List<TutorDto> getTutores();
}
