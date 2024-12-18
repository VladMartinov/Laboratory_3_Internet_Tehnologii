package com.example.studentapi.controller;

import com.example.studentapi.model.Student;
import com.example.studentapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/update")
    public String showUpdateForm(Model model) {
        model.addAttribute("student", new Student());
        return "update-student";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudentLastName(@PathVariable Long id, @RequestParam String lastName) {
        Student updatedStudent = studentService.updateStudentLastName(id, lastName);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }
}