package com.api.conectaProfessorAluno.services.impl;

import com.api.conectaProfessorAluno.services.*;
import org.springframework.stereotype.Service;

@Service
public class ServiceFacadeImpl implements ServiceFacade {
    private final TutorService tutorService;
    private final AlunoService alunoService;
    private final AgendaService agendaService;
    private final MaterialService materialService;

    public ServiceFacadeImpl(TutorService tutorService,
                             AlunoService alunoService,
                             AgendaService agendaService,
                             MaterialService materialService) {
        this.tutorService = tutorService;
        this.alunoService = alunoService;
        this.agendaService = agendaService;
        this.materialService = materialService;

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

    @Override
    public MaterialService getMaterialService() {
        return materialService;
    }
}
