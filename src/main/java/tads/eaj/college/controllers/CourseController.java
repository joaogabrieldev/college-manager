package tads.eaj.college.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tads.eaj.college.model.Course;
import tads.eaj.college.services.CourseService;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    private CourseService service;

    public CourseController(CourseService service){
        this.service = service;
    }

    @GetMapping
    public List<Course> listAll(){
        return service.getAll();
    }

    @GetMapping(path = { "/{id}" })
    public ResponseEntity<Course> findById(@PathVariable Long id) {
        return service.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Course> insert(@RequestBody Course course) {
        service.insert(course);
        return ResponseEntity.status(201).body(course);
    }

    @PutMapping(value = { "/{id}" })
    public ResponseEntity<Course> update(@PathVariable Long id, @RequestBody Course course) {
        return service.findById(id).map(record -> {
            service.saveAndFlush(course);
            return ResponseEntity.ok().body(course);
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
