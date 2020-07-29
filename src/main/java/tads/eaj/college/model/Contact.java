package tads.eaj.college.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String email;
    String phone;

    //@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    //@JoinColumn(name = "student_id")
    //Student student;
}
