package com.example.studentapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * step 2: create student controller class
 * add annotation- rest controller
 * make this class restful to serve
 */

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/student")
public class StudentController {

    /**
     * step 4: create a reference of student service class
     * annotated with autowire- which will connect that class to it
     */
    @Autowired
    private final StudentService studentService;

    //step 5: create constructor
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /*@GetMapping
    public List<Student> hello(){
        return List.of(                     //now we have take this part to another class to make a service controller / component controller
                new Student(
                "Arif",
                "arif@gmail.com",
                LocalDate.of(2000, Month.DECEMBER, 21),
                21
                )
        );
    }*/

    /**
     * restful endpoint
     * @return
     */
    @GetMapping
    public List<Student> getStudent(){
        //step 6: with the help of student service we need to call that method
        return studentService.getStudent();
    }

    //post mapping:
    @PostMapping(path = "/addStudent")
    public void registerNewStudent(@RequestBody Student student){   //as it will come from form request: -> add annotaion request body
        studentService.addStudent(student);
    }

    //delete mapping
    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId){
        studentService.deleteStudent(studentId);
    }

}
