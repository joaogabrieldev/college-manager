package tads.eaj.college.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tads.eaj.college.model.Discipline;
import tads.eaj.college.model.Student;
import tads.eaj.college.repository.DisciplineRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplineService {
    private DisciplineRepository repository;

    @Autowired
    public DisciplineService(DisciplineRepository repository) {
        this.repository = repository;
    }

    public Discipline insert(Discipline discipline) {
        return repository.save(discipline);
    }

    public Discipline update(Discipline discipline) {
        return repository.save(discipline);
    }

    public void delete(Discipline discipline) {
        repository.delete(discipline);
    }

    public Discipline getOne(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Discipline> getAll() {
        return repository.findAll();
    }

    public Optional<Discipline> findById(Long id) { return repository.findById(id); }

    public Discipline saveAndFlush(Discipline discipline) { return repository.saveAndFlush(discipline); }
}
