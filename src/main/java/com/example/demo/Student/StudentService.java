package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private static StudentRepository studentRepository = null;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    //singleton
    private static StudentService studentServiceObj = new StudentService(studentRepository);
    public static StudentService getStudentService(){
        return studentServiceObj;
    }


    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student){
        Optional<Student> studentByEmail = studentRepository.findByEmail(student.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("email exists");
        }
        studentRepository.save(student);
    }
    public Optional<Student> getByEmail(String email){
        return studentRepository.getByEmail(email);
    }
    public void deleteStudent(Long studentId){
        boolean studentByEmail = studentRepository.existsById(studentId);
        if(!studentByEmail){
            throw new IllegalStateException("id does not exists");
        }
        studentRepository.deleteById(studentId);
    }
}
