package com.example.studentapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * step 6: to access database we need to create student repository interface
 *  it will extend JpaRepository
 *  add annotation repository- responsible for data access- data access layer
 */

@Repository
public interface StudentRepository
        extends JpaRepository<Student,Integer> {

    @Query("from Student")
    List<Student> findAllStudents();
}
