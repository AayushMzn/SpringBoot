package com.example.demo.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @Autowired
    private TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @GetMapping(path = "/getTeacher")
    public List<Teacher> getTeacher() {
        return teacherService.getTeachers();
    }
    @PostMapping(path = "/newTeacher")
    public void newTeacher(@RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
    }

    @DeleteMapping(path = "/deleteStudent/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        teacherService.deleteStudent(studentId);
    }
}