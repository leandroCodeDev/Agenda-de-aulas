package com.api.conectaProfessorAluno.controlleres;



import com.api.conectaProfessorAluno.dto.MaterialDto;
import com.api.conectaProfessorAluno.services.MaterialService;
import com.api.conectaProfessorAluno.services.ServiceFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/materiais")
public class MaterialController {
    private final MaterialService materialService;

    public MaterialController(ServiceFacade serviceFacade) {
        this.materialService = serviceFacade.getMaterialService();
        this.materialService.setAgendaService(serviceFacade.getAgendaService());

    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterialDto> getMaterial(@PathVariable(name = "id") UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(materialService.getMaterial(id));
    }



    @GetMapping
    public ResponseEntity<List<MaterialDto>> getMateriais(){
        List<MaterialDto> materials = materialService.getMateriais();
        return ResponseEntity.status(HttpStatus.OK).body(materials);
    }



    @PostMapping
    public ResponseEntity<MaterialDto> create(@RequestBody MaterialDto materialRequest){
        MaterialDto material = materialService.create(materialRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(material);

    }

    @PutMapping("/{id}")
    public ResponseEntity<MaterialDto> update(@PathVariable(name = "id") UUID id, @RequestBody MaterialDto materialRequest){
        MaterialDto material = materialService.update(id,materialRequest);
        return ResponseEntity.status(HttpStatus.OK).body(material);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") UUID  id){
        materialService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
