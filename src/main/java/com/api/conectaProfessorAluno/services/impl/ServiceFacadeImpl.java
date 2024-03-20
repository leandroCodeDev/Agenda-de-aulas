package com.api.conectaProfessorAluno.services.impl;

import com.api.conectaProfessorAluno.services.AgendaService;
import com.api.conectaProfessorAluno.services.AlunoService;
import com.api.conectaProfessorAluno.services.ServiceFacade;
import com.api.conectaProfessorAluno.services.TutorService;
import org.springframework.stereotype.Service;

@Service
public class ServiceFacadeImpl implements ServiceFacade {
    private final TutorService tutorService;
    private final AlunoService alunoService;
    private final AgendaService agendaService;

    public ServiceFacadeImpl(TutorService tutorService, AlunoService alunoService, AgendaService agendaService) {
        this.tutorService = tutorService;
        this.alunoService = alunoService;
        this.agendaService = agendaService;
    }

    @Override
    public TutorService getTutorService() {
        return tutorService;
    }

    @Override
    public AlunoService getAlunoService() {
        return alunoService;
    }

    @Override
    public AgendaService getAgendaService() {
        return agendaService;
    }
}
