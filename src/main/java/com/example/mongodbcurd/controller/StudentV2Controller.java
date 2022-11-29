package com.example.mongodbcurd.controller;

import com.example.mongodbcurd.dto.StudentDTO;
import com.example.mongodbcurd.entity.Student;
import com.example.mongodbcurd.service.StudentV2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/student")
public class StudentV2Controller {
    private final StudentV2Service studentV2Service;

    @Autowired
    public StudentV2Controller(StudentV2Service studentV2Service) {
        this.studentV2Service = studentV2Service;
    }

    @PostMapping("/create")
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) {
        return new ResponseEntity<>(studentV2Service.createStudent(studentDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable String id){
        return new ResponseEntity<>(studentV2Service.getStudentById(id), HttpStatus.OK);
    }
}

