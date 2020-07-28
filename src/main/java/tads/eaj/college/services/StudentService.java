package tads.eaj.college.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tads.eaj.college.model.Student;
import tads.eaj.college.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student insert(Student student) {
        return repository.save(student);
    }

    public Student update(Student student) {
        return repository.save(student);
    }

    public void delete(Student student) {
        repository.delete(student);
    }

    public Student getOne(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Student> getAll() {
        return repository.findAll();
    }

    public Optional<Student> findById(Long id) { return repository.findById(id); }

    public Student saveAndFlush(Student student) { return repository.saveAndFlush(student); }
}
