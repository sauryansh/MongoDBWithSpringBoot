package com.example.mongodbcurd.service;

import com.example.mongodbcurd.entity.Student;
import com.example.mongodbcurd.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(String id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> getAllStudentDetails() {
        return studentRepository.findAll();
    }

    public Student updateStudentDetail(Student student) {
        return studentRepository.save(student);
    }

    public String deleteStudentById(String id) {
        Student student= studentRepository.findById(id).orElse(null);
        if(student!=null){
            studentRepository.deleteById(id);
            return "Student has been deleted";
        }else{
            return "No Record for given ID found";
        }

    }

    public List<Student> getStudentByName(String name) {
        return studentRepository.findByName(name);
    }

    public List<Student> getStudentDetailsByNameAndEmail(String name, String email) {
        return studentRepository.findByNameAndEmail(name,email);
    }

    public List<Student> getSudentsDetailsWhoseEmailEndWith(String emailExtension) {
        return studentRepository.findStudentsByEmailContaining(emailExtension);
    }

    public List<Student> studentsByNameOrMail(String name, String email) {
        return studentRepository.findStudentByNameOrEmail(name,email);
    }
}
