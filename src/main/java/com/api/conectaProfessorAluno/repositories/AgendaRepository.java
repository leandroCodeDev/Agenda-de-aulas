package com.api.conectaProfessorAluno.repositories;

import com.api.conectaProfessorAluno.entitys.AgendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface AgendaRepository extends JpaRepository<AgendaEntity, UUID> {
    List<AgendaEntity> findAgendasByAlunoIdOrderByDataAulaAsc(UUID idAluno);
    List<AgendaEntity> findAgendasByTutorIdOrderByDataAulaAsc(UUID idTutor);

    List<AgendaEntity>  findAgendasByAlunoIdAndDataAulaGreaterThanEqualOrderByDataAulaAsc(UUID alunoId, Date dataAtual);
    List<AgendaEntity>  findAgendasByTutorIdAndDataAulaGreaterThanEqualOrderByDataAulaAsc(UUID alunoId, Date dataAtual);
}
