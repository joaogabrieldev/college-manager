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

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nameStudent;

    @OneToOne (cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn
    Contact contact;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    Course course;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable (
            name = "student_discipline",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "discipline_id")
    )
    List<Discipline> disciplines;


}
