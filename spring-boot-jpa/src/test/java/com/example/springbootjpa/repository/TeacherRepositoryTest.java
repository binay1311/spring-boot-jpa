package com.example.springbootjpa.repository;

import com.example.springbootjpa.entity.Course;
import com.example.springbootjpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseDBMS = Course.builder()
                .title("DBMS")
                .credit(5)
                .build();

        Course courseJAVA = Course.builder()
                .title("JAVA")
                .credit(6)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Ramesh")
                .lastName("Gaikwad")
                //.courses(List.of(courseDBMS, courseJAVA))
                .build();

        teacherRepository.save(teacher);
    }

}