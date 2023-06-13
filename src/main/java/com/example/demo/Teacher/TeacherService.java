package com.example.demo.Teacher;

import com.example.demo.Student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher){
        Optional<Teacher> studentByEmail = teacherRepository.findByEmail(teacher.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("email exists");
        }
        teacherRepository.save(teacher);
    }

    public void deleteStudent(Long studentId){
        StudentService studentService = StudentService.getStudentService();
        studentService.deleteStudent(studentId);
    }
}
