package com.example.learning;

import com.example.Student;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface LearningService {
    @WebMethod
    List<Student> findStudentByLastName(String lastName);

    @WebMethod
    List<Student> findStudentsByAverageGrade(double averageGrade);

    @WebMethod
    List<Student> getAllStudent();
}
