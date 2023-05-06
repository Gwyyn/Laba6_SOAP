package com.example.learning;

import com.example.Student;

import javax.annotation.PostConstruct;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebService(endpointInterface = "com.example.learning.LearningService")
public class LearningServiceImpl implements LearningService {

    public List<Student> students = new ArrayList<>();

    @PostConstruct
    private void initData() {
        students.add(new Student("Иванов", 7.5));
        students.add(new Student("Петров", 8.8));
        students.add(new Student("Сидоров", 9.2));
    }

    public List<Student> findStudentByLastName(String lastName) {
        return students.stream().filter(item -> item.getLastName().startsWith(lastName)).collect(Collectors.toList());
    }

    public List<Student> findStudentsByAverageGrade(double averageGrade) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade) {
                result.add(student);
            }
        }
        return result;
    }

    @Override
    public List<Student> getAllStudent() {
        return students;
    }
}
