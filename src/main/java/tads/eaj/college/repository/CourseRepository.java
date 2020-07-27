package tads.eaj.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tads.eaj.college.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
