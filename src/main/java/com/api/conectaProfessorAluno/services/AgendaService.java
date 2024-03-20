package com.api.conectaProfessorAluno.services;

import com.api.conectaProfessorAluno.dto.AgendaDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public interface AgendaService {
    void setTutorService(TutorService tutorService);

    void setAlunoService(AlunoService alunoService);

    public AgendaDto create(AgendaDto tutor);
    public AgendaDto update(UUID idAgenda,AgendaDto tutor);


    public void delete(UUID idAgenda);
    public AgendaDto getAgenda(UUID idAgenda);
    public List<AgendaDto> getAgendas();
}
