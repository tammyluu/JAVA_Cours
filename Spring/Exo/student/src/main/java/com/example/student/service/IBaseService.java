package com.example.student.service;

import com.example.student.model.Student;

import java.util.List;
import java.util.UUID;

public interface IBaseService {
    Boolean createStudent(Student student);
    List<Student> findAllStudents();
    Student findStudentById(UUID id);
    Student findStudentByName(String firstName);
    List<Student> searchStudents(String search);
    Student updateStudent(UUID id, Student student);
    void deleteStudentById(UUID id);



}
