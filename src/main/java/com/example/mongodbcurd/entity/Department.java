package com.example.mongodbcurd.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Department {
    @Field("department_name")
    private String departmentName;
    @Field("location")
    private String location;
}
