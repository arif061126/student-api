package com.example.studentapi;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

/**
 * step 1: make entity class for which we need to store the data in the db
 */

@Entity
@Table(name = "student_table")
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private int studentId;
    private String studentName;
    private String studentEmail;
    private LocalDate studentDateOfBirth;
    @Transient
    private int studentAge;

    public Student() {
    }

    public Student(String studentName,
                   String studentEmail,
                   LocalDate studentDateOfBirth,
                   int studentAge) {
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentDateOfBirth = studentDateOfBirth;
        this.studentAge = studentAge;
    }

    public Student(
                   String studentName,
                   String studentEmail,
                   LocalDate studentDateOfBirth) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentDateOfBirth = studentDateOfBirth;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public LocalDate getStudentDateOfBirth() {
        return studentDateOfBirth;
    }

    public void setStudentDateOfBirth(LocalDate studentDateOfBirth) {
        this.studentDateOfBirth = studentDateOfBirth;
    }

    public int getStudentAge() {
        return Period.between(this.studentDateOfBirth,LocalDate.now()).getYears();
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                ", studentDateOfBirth=" + studentDateOfBirth +
                ", studentAge=" + studentAge +
                '}';
    }
}
