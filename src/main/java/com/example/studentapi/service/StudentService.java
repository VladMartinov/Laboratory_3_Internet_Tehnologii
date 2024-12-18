package com.example.studentapi.service;

import com.example.studentapi.model.Student;
import com.example.studentapi.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student updateStudentLastName(Long studentId, String newLastName) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student with id " + studentId + " not found"));

        student.setLastName(newLastName);
        return studentRepository.save(student);
    }
}