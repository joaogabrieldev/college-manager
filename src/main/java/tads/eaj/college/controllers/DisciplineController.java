package tads.eaj.college.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tads.eaj.college.model.Discipline;
import tads.eaj.college.services.DisciplineService;
import java.util.List;

@RestController
@RequestMapping("/discipline")
public class DisciplineController {
    private DisciplineService service;

    public DisciplineController(DisciplineService service){
        this.service = service;
    }

    @GetMapping
    public List<Discipline> listAll(){
        return service.getAll();
    }

    @GetMapping(path = { "/{id}" })
    public ResponseEntity<Discipline> findById(@PathVariable Long id) {
        return service.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Discipline> insert(@RequestBody Discipline discipline) {
        service.insert(discipline);
        return ResponseEntity.status(201).body(discipline);
    }

    @PutMapping(value = { "/{id}" })
    public ResponseEntity<Discipline> update(@PathVariable Long id, @RequestBody Discipline discipline) {
        return service.findById(id).map(record -> {
            service.saveAndFlush(discipline);
            return ResponseEntity.ok().body(discipline);
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
