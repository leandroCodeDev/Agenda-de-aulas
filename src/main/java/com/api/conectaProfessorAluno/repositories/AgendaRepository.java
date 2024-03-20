package com.api.conectaProfessorAluno.repositories;

import com.api.conectaProfessorAluno.entitys.AgendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AgendaRepository extends JpaRepository<AgendaEntity, UUID> {
}
