package com.example.studentapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/**
 * step 9: make a configuration to make change to db
 * add annotation configuration
 */

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student student1=new Student(
                    "Arif",
                    "arif@gmail.com",
                    LocalDate.of(2000, Month.DECEMBER, 21)
            );
            Student student2=new Student(
                    "Asif",
                    "asif@gmail.com",
                    LocalDate.of(1989, Month.JANUARY, 01)
            );

            //step 10: save these data to data base
            repository.saveAll(List.of(student1,student2));
        };
    }
}
