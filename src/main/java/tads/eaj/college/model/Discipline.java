package tads.eaj.college.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Discipline {
    @Id
    Long id;

    String nameDiscipline;
    Integer Horas;

    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "discipline_students",
        joinColumns = @JoinColumn(name = "discipline_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    List<Student> Students;

}
