package tads.eaj.college.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nameStudent;

    @OneToOne(mappedBy = "student", cascade = {CascadeType.ALL}, orphanRemoval = true)
    Contact contact;

    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;




}
