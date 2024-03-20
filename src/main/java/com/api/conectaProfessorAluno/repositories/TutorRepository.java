package com.api.conectaProfessorAluno.repositories;

import com.api.conectaProfessorAluno.entitys.TutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TutorRepository extends JpaRepository<TutorEntity, UUID> {
}
