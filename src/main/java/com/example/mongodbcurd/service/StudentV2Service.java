package com.example.mongodbcurd.service;

import com.example.mongodbcurd.dto.StudentDTO;

public interface StudentV2Service {
    public StudentDTO createStudent(StudentDTO studentDTO);


    public StudentDTO getStudentById(String id);
}
