package com.example.mongodbcurd.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.List;
@Data
@Document(collection = " ")
public class Student {
    @Id
    private String id;
    @Field("name")
    private String name;
    @Field("mail")
    private String email;
    @Field("department")
    private Department department;
    @Field("subjects")
    private List<Subject> subjects;

    public double getPercentage() {
        if(subjects!=null && !subjects.isEmpty()){
            double totalMarks=0;
            for(Subject subject:subjects){
                totalMarks+=subject.getMarksObtained();
            }
            return totalMarks/subjects.size();
        }
        return 0.00;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    @Transient
    private double percentage;
}
