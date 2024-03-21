package com.api.conectaProfessorAluno.services;

import com.api.conectaProfessorAluno.dto.MaterialDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public interface MaterialService {

    public void setAgendaService(AgendaService service);
    public MaterialDto create(MaterialDto dto);
    public MaterialDto update(UUID id,MaterialDto dto);


    public void delete(UUID id);
    public MaterialDto getMaterial(UUID id);
    public List<MaterialDto> getMateriais();
}
