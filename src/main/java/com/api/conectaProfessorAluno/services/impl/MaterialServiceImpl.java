package com.api.conectaProfessorAluno.services.impl;

import com.api.conectaProfessorAluno.dto.MaterialDto;
import com.api.conectaProfessorAluno.entitys.AgendaEntity;
import com.api.conectaProfessorAluno.entitys.MaterialEntity;
import com.api.conectaProfessorAluno.entitys.AlunoEntity;
import com.api.conectaProfessorAluno.entitys.TutorEntity;
import com.api.conectaProfessorAluno.helpers.BeansHelper;
import com.api.conectaProfessorAluno.repositories.MaterialRepository;
import com.api.conectaProfessorAluno.services.AgendaService;
import com.api.conectaProfessorAluno.services.MaterialService;
import com.api.conectaProfessorAluno.services.AlunoService;
import com.api.conectaProfessorAluno.services.TutorService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;
    private AgendaService agendaService;


    public MaterialServiceImpl(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public void setAgendaService(AgendaService agendaService) {
        this.agendaService = agendaService;
    }



    @Override
    public MaterialDto create(MaterialDto material) {
        MaterialEntity materialEntity = new MaterialEntity();
        BeanUtils.copyProperties(material,materialEntity);
        AgendaEntity agenda = agendaService.getAgendaEntity(material.idAgenda());
        materialEntity.setAgenda(agenda);
        materialEntity = materialRepository.save(materialEntity);
        return materialEntity.toDto();
    }

    @Override
    public MaterialDto update(UUID idMaterial,MaterialDto material) {
        MaterialEntity materialEntity = materialRepository.findById(idMaterial).orElseThrow(() -> new RuntimeException("Objeto não enocntrado"));
        BeansHelper.copyNonNullProperties(material,materialEntity);
        materialRepository.save(materialEntity);
        return materialEntity.toDto();
    }

    @Override
    public void delete(UUID idMaterial) {
        MaterialEntity material = materialRepository.findById(idMaterial).orElseThrow(() -> new RuntimeException("Objeto não enocntrado"));
        materialRepository.delete(material);
    }

    @Override
    public MaterialDto getMaterial(UUID idMaterial) {
        MaterialEntity material = materialRepository.findById(idMaterial).orElseThrow(() -> new RuntimeException("Objeto não enocntrado"));
        return material.toDto();
    }

    @Override
    public List<MaterialDto> getMateriais() {
        return materialRepository.findAll().stream()
                .map(MaterialEntity::toDto)
                .collect(Collectors.toList());
    }
}
