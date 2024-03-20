package com.api.conectaProfessorAluno.services;

public interface ServiceFacade {
    TutorService getTutorService();

    AlunoService getAlunoService();

    AgendaService getAgendaService();
}
