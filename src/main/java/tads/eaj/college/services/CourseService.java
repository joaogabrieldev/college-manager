package tads.eaj.college.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tads.eaj.college.model.Course;
import tads.eaj.college.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private CourseRepository repository;

    @Autowired
    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public Course insert(Course course) {
        return repository.save(course);
    }

    public Course update(Course course) {
        return repository.save(course);
    }

    public void delete(Course course) {
        repository.delete(course);
    }

    public Course getOne(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Course> getAll() {
        return repository.findAll();
    }

    public Optional<Course> findById(Long id) { return repository.findById(id); }

    public Course saveAndFlush(Course course) { return repository.saveAndFlush(course); }

}
