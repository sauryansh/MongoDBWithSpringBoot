package com.example.mongodbcurd.service.impl;

import com.example.mongodbcurd.entity.Student;
import com.example.mongodbcurd.repository.StudentRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.SortedMap;

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

    public List<Student> getAllStudentsWithSorting(String sortBy, String orderBy) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortBy),orderBy);
        return studentRepository.findAll(sort);
    }

    public List<Student> getStudentsByDepartmentName(String departmentName) {
        return studentRepository.findByDepartmentDepartmentName(departmentName);
    }

    public List<Student> getStudentsBySubjectName(String subjectName) {
        return studentRepository.findBySubjectsSubjectName(subjectName);
    }

    public List<Student> getStudentsByEmailLike(String email) {
        return studentRepository.findByEmailIsLike(email);
    }

    public List<Student> getStudentsByNameStartWith(String name) {
        return studentRepository.findByNameStartsWith(name);
    }
}
