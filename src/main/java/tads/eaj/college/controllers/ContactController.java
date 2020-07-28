package tads.eaj.college.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tads.eaj.college.model.Contact;
import tads.eaj.college.services.ContactService;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {
    private ContactService service;

    public ContactController(ContactService service){
        this.service = service;
    }

    @GetMapping
    public List<Contact> listAll(){
        return service.getAll();
    }

    @GetMapping(path = { "/{id}" })
    public ResponseEntity<Contact> findById(@PathVariable Long id) {
        return service.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Contact> insert(@RequestBody Contact contact) {
        service.insert(contact);
        return ResponseEntity.status(201).body(contact);
    }

    @PutMapping(value = { "/{id}" })
    public ResponseEntity<Contact> update(@PathVariable Long id, @RequestBody Contact contact) {
        return service.findById(id).map(record -> {
            service.saveAndFlush(contact);
            return ResponseEntity.ok().body(contact);
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
