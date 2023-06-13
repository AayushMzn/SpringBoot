package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    private StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping(path = "/getStudents")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
    @PostMapping(path = "/setStudent")
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
    @DeleteMapping(path = "/deleteStudent/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }
    @PostMapping(path = "/getStudentByEmail/{email}")
    public Optional<Student> getByEmail(@PathVariable("email") String email){
        return studentService.getByEmail(email);
    }
}