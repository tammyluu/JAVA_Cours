package com.example.exercice_student.controller;


import com.example.exercice_student.model.Student;
import com.example.exercice_student.service.IStudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/academy")
@AllArgsConstructor
public class StudentRestController {

    private final IStudentService studentService;


    @GetMapping("/students") //http://localhost:8080/api/v1/academy/students
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")//http://localhost:8080/api/v1/academy/student/{id}
    public Student getStudentById(@PathVariable("id") Long id){
        System.out.println(id);
        System.out.println(studentService.getStudentById(id));
        return studentService.getStudentById(id);
    }
    @PostMapping("/add")//http://localhost:8080/api/v1/academy/add
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
    @PostMapping("/addstudent")//http://localhost:8080/api/v1/academy/add
    public ResponseEntity<String> createStudent(@Valid @RequestBody Student student, BindingResult result){
        if(result.hasErrors()){
            StringBuilder errors = new StringBuilder();
            result.getAllErrors().forEach(objectError -> errors.append(objectError.toString()+ "|") );
            return  new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
        }
           studentService.createStudent(student);
        return new ResponseEntity<>("Student is created with id: "+ student.getId(), HttpStatus.CREATED);
    }

    @DeleteMapping("/student/{id}")//http://localhost:8080/api/v1/academy/student/x
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }
    @PutMapping("/student/{id}")//http://localhost:8080/api/v1/academy/student/x
    public void updateStudent(@PathVariable Long id, @RequestBody Student updateStudent){
        studentService.updateStudent(id, updateStudent );
    }
    @PutMapping("/studentvalid/{id}")//http://localhost:8080/api/v1/academy/student/x
    public ResponseEntity<String> updateStudentValid( @Valid @PathVariable Long id, @RequestBody Student updateStudent, BindingResult result){
        if(result.hasErrors()){
            StringBuilder errors = new StringBuilder();
            result.getAllErrors().forEach(objectError -> errors.append(objectError.toString()+ "|") );
            return  new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
        }
        studentService.updateStudent(id, updateStudent );
        return new ResponseEntity<>("Modify student ok", HttpStatus.ACCEPTED);
    }



}
