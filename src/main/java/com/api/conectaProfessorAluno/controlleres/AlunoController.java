package com.api.conectaProfessorAluno.controlleres;

import com.api.conectaProfessorAluno.dto.AlunoDto;
import com.api.conectaProfessorAluno.services.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDto> getAluno(@PathVariable(name = "id") UUID  id){
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.getAluno(id));
    }



    @GetMapping
    public ResponseEntity<List<AlunoDto>> getAlunos(){
        List<AlunoDto> alunos = alunoService.getAlunos();
        return ResponseEntity.status(HttpStatus.OK).body(alunos);
    }



    @PostMapping
    public ResponseEntity<AlunoDto> create(@RequestBody AlunoDto alunoRequest){
        AlunoDto aluno = alunoService.create(alunoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(aluno);

    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoDto> update(@PathVariable(name = "id") UUID id, @RequestBody AlunoDto alunoRequest){
        AlunoDto aluno = alunoService.update(id,alunoRequest);
        return ResponseEntity.status(HttpStatus.OK).body(aluno);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") UUID  id){
        alunoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}
