package tads.eaj.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tads.eaj.college.model.Discipline;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
}
