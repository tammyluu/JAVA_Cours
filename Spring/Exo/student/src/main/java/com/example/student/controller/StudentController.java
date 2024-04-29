package com.example.student.controller;

import com.example.student.model.Student;
import com.example.student.service.IBaseService;
import com.example.student.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller

public class StudentController {

    private final IBaseService studentService;

    @Value("M2i")
    private String academyName;

    @Value("formation@m2i.fr")
    private String academycontact;

    public StudentController(IBaseService studentService) {
        this.studentService = studentService;
    }

    @GetMapping // http://localhost:8080
    public String homePage(Model model){
        model.addAttribute("name", academyName);
        model.addAttribute("contact", academycontact);
        return "home";
    }
    @GetMapping("/detail/{studentId}")
    public String showStudentProfil(@PathVariable("studentId")UUID id, Model model){
       model.addAttribute("student", studentService.findStudentById(id));
        return "detail";
    }
    @GetMapping("/list")
    public String showAllStudents(@RequestParam(name = "keyword", required = false)String keyword, Model model)   {
        if(keyword ==null){
            model.addAttribute("students", studentService.findAllStudents());
        }else {
            model.addAttribute("students", studentService.searchStudents(keyword));

        }
        return "students";
    }
    @GetMapping("/add")
    public String addStudent(Model model){
        model.addAttribute("student", new Student());
        //prendre ce obj Student vide pour envoyer vers le model
        return "form";
    }
    @PostMapping("/add")
    //Rendre ce obj"student"avec ses attributes
    public  String saveStudent(@Valid @ModelAttribute("student")Student student, BindingResult bindingResult){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        if (bindingResult.hasErrors()){
            return "form";
        }
        studentService.createStudent(student);
        // redirect url doit aller , plus de page régider
        return "form-confirm";
    }
   /* @GetMapping("/search")
    public String  showOneStudentByName (@RequestParam(name="keyword",defaultValue = "" )String keyword, Model model){
        System.out.println(keyword);
        Student student = studentService.findStudentByName(keyword);

        if (student != null){
            model.addAttribute("student", student);
            return "detail";
        }else
            return "error";
    }*/

    @GetMapping("/delete")
    public  String deleteStudent (@RequestParam("studentId")UUID id){
        studentService.deleteStudentById(id);
        System.out.println("delete successful");
        return "redirect:/list";
    }
    @PostMapping ("/update")
    public  String updateStudent(@RequestParam("studentId") UUID id,Model model){
        Student student = studentService.findStudentById(id);
        model.addAttribute("student", student);
        System.out.println("update student");
        return "redirect:/list";
    }


}

