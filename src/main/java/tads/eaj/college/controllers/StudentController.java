package tads.eaj.college.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tads.eaj.college.model.Student;
import tads.eaj.college.services.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = {"http://localhost:3000"}, exposedHeaders = "X-Total-Count")
public class StudentController {
    private StudentService service;

    public StudentController(StudentService service){
        this.service = service;
    }

    @GetMapping
    public List<Student> listAll(){
        return service.getAll();
    }

    @GetMapping(path = { "/{id}" })
    public ResponseEntity<Student> findById(@PathVariable Long id) {
        return service.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Student> insert(@RequestBody Student student) {
        service.insert(student);
        return ResponseEntity.status(201).body(student);
    }

    @PutMapping(value = { "/{id}" })
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student) {
        return service.findById(id).map(record -> {
            service.saveAndFlush(student);
            return ResponseEntity.ok().body(student);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return service.findById(id).map(record -> {
            service.delete(record);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

}
