package tads.eaj.college.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tads.eaj.college.model.Contact;
import tads.eaj.college.model.Course;
import tads.eaj.college.repository.ContactRepository;


import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    private ContactRepository repository;

    @Autowired
    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    public Contact insert(Contact contact) {
        return repository.save(contact);
    }

    public Contact update(Contact contact) {
        return repository.save(contact);
    }

    public void delete(Contact contact) {
        repository.delete(contact);
    }

    public Contact getOne(Long id) {  return repository.findById(id).orElse(null); }

    public List<Contact> getAll() {
        return repository.findAll();
    }

    public Optional<Contact> findById(Long id) { return repository.findById(id); }

    public Contact saveAndFlush(Contact contact) { return repository.saveAndFlush(contact); }
}
