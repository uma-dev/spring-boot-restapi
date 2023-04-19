package com.umadev.restapi.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umadev.restapi.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    
    // Define endpoint for "/students" (return a list of Students)
    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> theStudents = new ArrayList<Student>();
        theStudents.add( new Student("first1", "lastName1"));
        theStudents.add( new Student("first2", "lastName2"));
        theStudents.add( new Student("first3", "lastName3"));
        
        return theStudents;
    }
}
