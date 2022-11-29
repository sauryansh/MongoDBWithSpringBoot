package com.example.mongodbcurd.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
@Data
public class StudentDTO {
    @Field("id")
    private String id;
    @Field("name")
    private String name;
    @Field("mail")
    private String email;
    @Field("department")
    private Department department;
    @Field("subjects")
    private List<Subject> subjects;
}
