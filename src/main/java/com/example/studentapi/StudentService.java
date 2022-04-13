package com.example.studentapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * step 3: create a service layer to communicate with controller layer
 * for business logic
 */

@Service
public class StudentService {

    //step 7: make instance of repository class
    //annotated with autowired
    @Autowired
    private final StudentRepository studentRepository;

    //step 8: make constuctor
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /*public List<Student> getStudent(){
        return List.of(                     //now we have take this part to another class to make a Repository to access db
                new Student(
                        "Arif",
                        "arif@gmail.com",
                        LocalDate.of(2000, Month.DECEMBER, 21),
                        21
                )
        );
    }*/

    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        System.out.println(student);
        this.studentRepository.save(student);
    }

    public void deleteStudent(Integer studentId) {
        boolean exists = this.studentRepository.existsById(studentId);

        if(!exists){
            throw new IllegalStateException("Student with ID: "+studentId+" does not exist");
        }

        this.studentRepository.deleteById(studentId);
    }

    public Student updateStudent(Integer studentId, Student studentDetails){
        Student student = this.studentRepository.findById(studentId).orElseThrow(
                () -> new NoSuchElementException("Student with ID: " + studentId + " does not exist")
        );
        student.setStudentName(studentDetails.getStudentName());
        student.setStudentEmail(studentDetails.getStudentEmail());
        student.setStudentDateOfBirth(studentDetails.getStudentDateOfBirth());

        return this.studentRepository.save(student);
    }

    public Optional<Student> getStudentById(Integer studentId){
        boolean exists = this.studentRepository.existsById(studentId);

        if(!exists){
            throw new IllegalStateException("Student with ID: "+studentId+" does not exist");
        }
        return this.studentRepository.findById(studentId);

    }
}
