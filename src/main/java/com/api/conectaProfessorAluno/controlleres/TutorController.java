package com.api.conectaProfessorAluno.controlleres;



import com.api.conectaProfessorAluno.dto.TutorDto;
import com.api.conectaProfessorAluno.services.TutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tutores")
public class TutorController {
    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TutorDto> getTutor(@PathVariable(name = "id") UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(tutorService.getTutor(id));
    }



    @GetMapping
    public ResponseEntity<List<TutorDto>> getTutors(){
        List<TutorDto> tutors = tutorService.getTutores();
        return ResponseEntity.status(HttpStatus.OK).body(tutors);
    }



    @PostMapping
    public ResponseEntity<TutorDto> create(@RequestBody TutorDto tutorRequest){
        TutorDto tutor = tutorService.create(tutorRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(tutor);

    }

    @PutMapping("/{id}")
    public ResponseEntity<TutorDto> update(@PathVariable(name = "id") UUID id, @RequestBody TutorDto tutorRequest){
        TutorDto tutor = tutorService.update(id,tutorRequest);
        return ResponseEntity.status(HttpStatus.OK).body(tutor);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") UUID  id){
        tutorService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
