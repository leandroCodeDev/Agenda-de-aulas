package com.api.conectaProfessorAluno.services.impl;

import com.api.conectaProfessorAluno.dto.AgendaDto;
import com.api.conectaProfessorAluno.entitys.AgendaEntity;
import com.api.conectaProfessorAluno.entitys.AlunoEntity;
import com.api.conectaProfessorAluno.entitys.TutorEntity;
import com.api.conectaProfessorAluno.helpers.BeansHelper;
import com.api.conectaProfessorAluno.repositories.AgendaRepository;
import com.api.conectaProfessorAluno.services.AgendaService;
import com.api.conectaProfessorAluno.services.AlunoService;
import com.api.conectaProfessorAluno.services.TutorService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AgendaServiceImpl implements AgendaService {

    private final AgendaRepository agendaRepository;
    private TutorService tutorService;
    private AlunoService alunoService;

    public AgendaServiceImpl(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    @Override
    public void setTutorService(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @Override
    public void setAlunoService(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @Override
    public AgendaDto create(AgendaDto agenda) {
        AlunoEntity aluno = alunoService.getAlunoEntity(agenda.idAluno());
        TutorEntity tutor = tutorService.getTutorEntity(agenda.idTutor());
        AgendaEntity agendaEntity = new AgendaEntity(agenda,aluno,tutor);
        agendaEntity = agendaRepository.save(agendaEntity);
        return agendaEntity.toDto();
    }

    @Override
    public AgendaDto update(UUID idAgenda,AgendaDto agenda) {
        AgendaEntity agendaEntity = agendaRepository.findById(idAgenda).orElseThrow(() -> new RuntimeException("Objeto não enocntrado"));
        BeansHelper.copyNonNullProperties(agenda,agendaEntity);
        agendaRepository.save(agendaEntity);
        return agendaEntity.toDto();
    }

    @Override
    public void delete(UUID idAgenda) {
        AgendaEntity agenda = agendaRepository.findById(idAgenda).orElseThrow(() -> new RuntimeException("Objeto não enocntrado"));
        agendaRepository.delete(agenda);
    }

    @Override
    public AgendaDto getAgenda(UUID idAgenda) {
        AgendaEntity agenda = agendaRepository.findById(idAgenda).orElseThrow(() -> new RuntimeException("Objeto não enocntrado"));
        return agenda.toDto();
    }


    @Override
    public AgendaEntity getAgendaEntity(UUID idAgenda) {
        return agendaRepository.findById(idAgenda).orElseThrow(() -> new RuntimeException("Objeto não enocntrado"));
    }
    @Override
    public List<AgendaDto> getAgendas() {
        return agendaRepository.findAll().stream()
                .map(AgendaEntity::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AgendaDto> getAlunosAgendas(UUID idAluno) {
        return agendaRepository.findAgendasByTutorIdOrderByNomeAsc(idAluno).stream()
                .map(this::mapToAgendaDto)
                .collect(Collectors.toList());

    }

    @Override
    public List<AgendaDto> getTutorAgendas(UUID idTutor) {
        List<AgendaEntity> agendas = agendaRepository.findAgendasByTutorIdOrderByNomeAsc(idTutor);

        return agendaRepository.findAgendasByTutorIdOrderByNomeAsc(idTutor).stream()
                .map(this::mapToAgendaDto)
                .collect(Collectors.toList());
    }

    private AgendaDto mapToAgendaDto(AgendaEntity agenda) {

        return new AgendaDto(agenda.getId(),agenda.getNome(),agenda.getStatus(),agenda.getTema(),agenda.getDescricao(),agenda.getDataAula(),agenda.getTutor().getId(),agenda.getAluno().getId());
    }
}
