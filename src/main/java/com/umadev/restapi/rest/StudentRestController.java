package com.umadev.restapi.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umadev.restapi.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to load student data only once

    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<Student>();
        theStudents.add( new Student("first1", "lastName1"));
        theStudents.add( new Student("first2", "lastName2"));
        theStudents.add( new Student("first3", "lastName3"));
    }
    
    // Define endpoint for "/students" (return a list of Students)
    @GetMapping("/students")
    public List<Student> getStudents(){
        
        //the return statement internally does a data binding and convert the 
        //Java POJO into a JSON file as you can see in localhost:8080/api/students
        return theStudents;
    }

    // Define endpoint for "/students/{studentId}" to return Student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent ( @PathVariable int studentId){
        // just index of list, can be a database. 
        return theStudents.get(studentId);
    }
}
