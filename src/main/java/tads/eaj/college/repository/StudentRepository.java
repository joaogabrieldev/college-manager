package tads.eaj.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tads.eaj.college.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
