package com.example.mongodbcurd.service.impl;

import com.example.mongodbcurd.dto.StudentDTO;
import com.example.mongodbcurd.entity.Student;
import com.example.mongodbcurd.repository.StudentRepository;
import com.example.mongodbcurd.service.StudentV2Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentV2ServiceImpl implements StudentV2Service {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public StudentV2ServiceImpl(StudentRepository studentRepository,ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = studentMapToEntity(studentDTO);
        Student newStudent = studentRepository.save(student);
        return studentMapToDTO(newStudent);
    }

    @Override
    public StudentDTO getStudentById(String id) {
        Student student = studentRepository.findById(id).orElse(null);
        return studentMapToDTO(student);
    }


    private StudentDTO studentMapToDTO(Student student) {
        return modelMapper.map(student, StudentDTO.class);
    }

    private Student studentMapToEntity(StudentDTO studentDTO) {
        return modelMapper.map(studentDTO, Student.class);
    }
}
