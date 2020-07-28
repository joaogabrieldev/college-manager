package tads.eaj.college;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import tads.eaj.college.repository.ContactRepository;
import tads.eaj.college.repository.CourseRepository;
import tads.eaj.college.repository.DisciplineRepository;
import tads.eaj.college.repository.StudentRepository;
import javax.transaction.Transactional;


@Component
public class RunMyCode implements ApplicationRunner {

    @Autowired
    CourseRepository CourseRepository;

    @Autowired
    ContactRepository ContactRepository;

    @Autowired
    DisciplineRepository DisciplineRepository;

    @Autowired
    StudentRepository StudentRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        /* --- ALL TESTS ---
        Course c1 = new Course();
        c1.setNameCourse("TADS");
        c1.setArea("Informatica");
        c1.setType("Tecnologo");

        Discipline d1 = new Discipline();
        Discipline d2 = new Discipline();
        Discipline d3 = new Discipline();
        Discipline d4 = new Discipline();
        d1.setNameDiscipline("Programação Web");
        d1.setHoras(90);
        d2.setNameDiscipline("Estrutura de Dados");
        d2.setHoras(60);
        d3.setNameDiscipline("Processamento de Imagens");
        d3.setHoras(45);
        d4.setNameDiscipline("Inteligencia Computacional");
        d4.setHoras(30);
        List<Discipline> disciplinesList = new ArrayList<>();
        disciplinesList.add(d1);
        disciplinesList.add(d2);
        disciplinesList.add(d3);
        disciplinesList.add(d4);

        d1.setCourse(c1);
        c1.setDisciplines(disciplinesList);
        d2.setCourse(c1);
        c1.setDisciplines(disciplinesList);
        d3.setCourse(c1);
        c1.setDisciplines(disciplinesList);
        d4.setCourse(c1);
        c1.setDisciplines(disciplinesList);

        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        s1.setNameStudent("Dimitrio");
        s2.setNameStudent("Ronaldinho");
        s3.setNameStudent("Azeitona");

        Contact cont1 = new Contact();
        Contact cont2 = new Contact();
        Contact cont3 = new Contact();
        cont1.setEmail("Dimitrio@gmail.com");
        cont1.setPhone("84996039376");
        cont2.setEmail("Ronaldinho@gmail.com");
        cont2.setPhone("84996039376");
        cont3.setEmail("Azeitona@gmail.com");
        cont3.setPhone("84996039376");
        s1.setContact(cont1);
        cont1.setStudent(s1);
        s2.setContact(cont2);
        cont2.setStudent(s2);
        s3.setContact(cont3);
        cont3.setStudent(s3);

        List<Student> studentsList = new ArrayList<>();
        studentsList.add(s1);
        studentsList.add(s2);
        studentsList.add(s3);

        s1.setCourse(c1);
        s2.setCourse(c1);
        s3.setCourse(c1);

        d1.setStudents(studentsList);
        d2.setStudents(studentsList);
        d3.setStudents(studentsList);
        d4.setStudents(studentsList);
        CourseRepository.save(c1);
        */




        /* --- MANY TO MANY | DISCIPLINES - STUDANTS
        Course c1 = new Course();
        c1.setNameCourse("TADS");
        c1.setArea("Informatica");
        c1.setType("Tecnologo");

        Discipline d1 = new Discipline();
        d1.setNameDiscipline("Programação Web");
        d1.setHoras(90);
        List<Discipline> disciplinesList = new ArrayList<>();
        disciplinesList.add(d1);
        d1.setCourse(c1);
        c1.setDisciplines(disciplinesList);

        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        s1.setNameStudent("Dimitrio");
        s2.setNameStudent("Ronaldinho");
        s3.setNameStudent("Azeitona");
        List<Student> studentsList = new ArrayList<>();
        studentsList.add(s1);
        studentsList.add(s2);
        studentsList.add(s3);

        d1.setStudents(studentsList);
        CourseRepository.save(c1);
        */




        /* --- ONE TO MANY | COURSE - DISCIPLINE ---

        Course c1 = new Course();
        c1.setNameCourse("TADS");
        c1.setArea("Informatica");
        c1.setType("Tecnologo");

        Discipline d1 = new Discipline();
        Discipline d2 = new Discipline();
        Discipline d3 = new Discipline();
        d1.setNameDiscipline("Programação Web");
        d2.setNameDiscipline("Estrutura de Dados");
        d3.setNameDiscipline("Inteligencia Computacional");
        List<Discipline> discipline = new ArrayList<>();
        discipline.add(d1);
        discipline.add(d2);
        discipline.add(d3);
        c1.setDisciplines(discipline);
        d1.setCourse(c1);
        d2.setCourse(c1);
        d3.setCourse(c1);
        CourseRepository.save(c1);
        */




        /* --- ONE TO MANY | COURSE - STUDENTS ---

        Course c1 = new Course();
        c1.setNameCourse("TADS");
        c1.setArea("Informatica");
        c1.setType("Tecnologo");

        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        s1.setNameStudent("Dimitrio");
        s2.setNameStudent("Ronaldinho");
        s3.setNameStudent("Azeitona");
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        c1.setStudents(students);
        s1.setCourse(c1);
        s2.setCourse(c1);
        s3.setCourse(c1);
        CourseRepository.save(c1);
         */




        /*
        --- ONE TO ONE | STUDENTS - CONTACT ---

        Student s1 = new Student();
        Contact c1 = new Contact();
        s1.setNameStudent("Joaozinho");
        c1.setEmail("Joaozinho@gmail.com");
        c1.setPhone(12345);

        s1.setContact(c1);
        c1.setStudent(s1);

        StudentRepository.save(s1);
        */

    }
}
