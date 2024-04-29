package com.example.exercice_student.service;

import com.example.exercice_student.model.Student;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class StudentServiceImpl implements IStudentService{




    private List<Student> students = new ArrayList<>();

    private Long currentId = 1L;

    @Override
    public Student createStudent(Student student) {
        student.setId(currentId++);
        students.add(student);
        return student;
    }

    @Override
    public Student getStudentById(Long id) {
        return students.stream().filter(student -> student.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public List<Student> searchStudents(String search) {
        return students.stream()
                .filter(student -> student.getFirstName().toLowerCase().contains(search.toLowerCase()) || student.getLastName().toLowerCase().contains(search.toLowerCase())).toList();
    }

    @Override
    public Student updateStudent(Long id, Student updateStudent) {
        Student studentExisting = getStudentById(id);
        if (studentExisting != null){
            studentExisting.setLastName(updateStudent.getLastName());
            studentExisting.setFirstName(updateStudent.getFirstName());
            studentExisting.setEmail(updateStudent.getEmail());
            studentExisting.setAge(updateStudent.getAge());
           return studentExisting;
        }
        return null;
    }

    @Override
    public void deleteStudent(Long id) {
        students.removeIf(student -> student.getId().equals(id));

    }
}
