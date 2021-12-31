package com.example.springbootjpa.repository;

import com.example.springbootjpa.entity.Guardian;
import com.example.springbootjpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("mariam.jonas@gmail.com")
                .firstName("Mariam")
                .lastName("Jonas")
                //.guardianName("Alex")
                //.guardianEmail("alex@gmail.com")
                //.guardianMobile("9999123456")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("alex")
                .email("alex@gmail.com")
                .mobile("1234567890")
                .build();

        Student student = Student.builder()
                .emailId("shivam.jonas@gmail.com")
                .firstName("shivam")
                .lastName("Jonas")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void findAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList : " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> list = studentRepository.findByFirstName("Mariam");
        System.out.println("Students : " + list);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> list = studentRepository.findByFirstNameContaining("shi");
        System.out.println("Students : " + list);
    }

    @Test
    public void printStudentByGuardianName(){
        List<Student> list = studentRepository.findByGuardianName("alex");
        System.out.println("Students : " + list);
    }

    @Test
    public void getStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailId("mariam.jonas@gmail.com");
        System.out.println("Student : " + student);
    }

    @Test
    public void getStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailIdNative("mariam.jonas@gmail.com");
        System.out.println("Student : " + student);
    }

    @Test
    public void getStudentByEmailIdNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailIdNative("mariam.jonas@gmail.com");
        System.out.println("Student : " + student);
    }

    @Test
    public void updateStudentByEmailId(){
        studentRepository.updateStudentByEmailId(
                "Mariam Cristopher",
                "mariam.jonas@gmail.com"
        );
    }

}