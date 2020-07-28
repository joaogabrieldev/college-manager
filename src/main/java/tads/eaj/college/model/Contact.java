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
    Long id;
    String email;
    String phone;

    @OneToOne
    @MapsId
    @JoinColumn(name = "student_id")
    Student student;
}
