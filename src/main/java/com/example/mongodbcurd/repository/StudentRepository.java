package com.example.mongodbcurd.repository;

import com.example.mongodbcurd.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    List<Student> findByName(String name); // Here we don't need to write native query,
                                                  // spring data provide method proxy in that,
                                                  //we provide correct method name and that will create native mongodb
                                                  // query and that will give us the result.
    List<Student> findByNameAndEmail(String name,String email);

    List<Student> findStudentsByEmailContaining(String value);

    List<Student> findStudentByNameOrEmail(String name,String email);

}
