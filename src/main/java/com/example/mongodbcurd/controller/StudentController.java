package com.example.mongodbcurd.controller;

import com.example.mongodbcurd.entity.Student;
import com.example.mongodbcurd.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/getById/{id}")
    public Student getStudentById(@PathVariable String id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents(){
        return studentService.getAllStudentDetails();
    }

    @PutMapping("/update")
    public Student updateStudentDetails(@RequestBody Student student){
        return studentService.updateStudentDetail(student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id){
        return studentService.deleteStudentById(id);
    }

    @GetMapping("/studentsByName/{name}")
    public List<Student> studentsByName(@PathVariable String name){
        return studentService.getStudentByName(name);
    }

    @GetMapping("/studentsByNameAndMail")
    public List<Student> studentsByNameAndMail(@RequestParam String name, @RequestParam String email){
        return studentService.getStudentDetailsByNameAndEmail(name,email);
    }

    @GetMapping("/studentEndingWithEmailExtension")
    public List<Student> studentsByEmailEndingWith(@RequestParam String emailExtension){
        return studentService.getSudentsDetailsWhoseEmailEndWith(emailExtension);
    }

    @GetMapping("studentsByNameOrMail")
    public List<Student> studentsByNameOrMail(@RequestParam String name,
                                              @RequestParam String email){
        return studentService.studentsByNameOrMail(name,email);
    }

}

