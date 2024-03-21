package com.api.conectaProfessorAluno.controlleres;



import com.api.conectaProfessorAluno.dto.AgendaDto;
import com.api.conectaProfessorAluno.services.AgendaService;
import com.api.conectaProfessorAluno.services.ServiceFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/agendas")
public class AgendaController {
    private final AgendaService agendaService;

    public AgendaController(ServiceFacade serviceFacade) {
        this.agendaService = serviceFacade.getAgendaService();
        this.agendaService.setAlunoService(serviceFacade.getAlunoService());
        this.agendaService.setTutorService(serviceFacade.getTutorService());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendaDto> getAgenda(@PathVariable(name = "id") UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(agendaService.getAgenda(id));
    }



    @GetMapping
    public ResponseEntity<List<AgendaDto>> getAgendas(){
        List<AgendaDto> agendas = agendaService.getAgendas();
        return ResponseEntity.status(HttpStatus.OK).body(agendas);
    }

    @GetMapping("/alunos/{id}")
    public ResponseEntity<List<AgendaDto>> getAlunosAgendas(@PathVariable(name = "id")UUID idAluno){
        List<AgendaDto> agendas = agendaService.getAlunosAgendas(idAluno);
        return ResponseEntity.status(HttpStatus.OK).body(agendas);
    }
    @GetMapping("/tutores/{id}")
    public ResponseEntity<List<AgendaDto>> getTutorAgendas(@PathVariable(name = "id")UUID idTutor){
        List<AgendaDto> agendas = agendaService.getTutorAgendas(idTutor);
        return ResponseEntity.status(HttpStatus.OK).body(agendas);
    }

    @GetMapping("/alunos/{id}/proximas")
    public ResponseEntity<List<AgendaDto>> getAlunosProximasAgendas(@PathVariable(name = "id")UUID idAluno){
        List<AgendaDto> agendas = agendaService.getAlunosProximasAgendas(idAluno);
        return ResponseEntity.status(HttpStatus.OK).body(agendas);
    }
    @GetMapping("/tutores/{id}/proximas")
    public ResponseEntity<List<AgendaDto>> getTutorProximasAgendas(@PathVariable(name = "id")UUID idTutor){
        List<AgendaDto> agendas = agendaService.getTutorProximasAgendas(idTutor);
        return ResponseEntity.status(HttpStatus.OK).body(agendas);
    }



    @PostMapping
    public ResponseEntity<AgendaDto> create(@RequestBody AgendaDto agendaRequest){
        AgendaDto agenda = agendaService.create(agendaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(agenda);

    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendaDto> update(@PathVariable(name = "id") UUID id, @RequestBody AgendaDto agendaRequest){
        AgendaDto agenda = agendaService.update(id,agendaRequest);
        return ResponseEntity.status(HttpStatus.OK).body(agenda);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") UUID  id){
        agendaService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Agenda removido com sucesso.");
    }



}
