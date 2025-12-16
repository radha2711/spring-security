package com.practice.spring.security.controller;

import com.practice.spring.security.entity.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>(List.of(new Student(1,"Radha",99),new Student(2,"Shiva",100)));

    @GetMapping("/")
    public String greet(){
        return "Welcome to Spring Security!! ";
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return students;
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }

    @GetMapping("/csrf-token")
    public CsrfToken csrftoken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");

    }
}
