package com.example.springbootjpa.repository;

import com.example.springbootjpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstname);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByGuardianName(String name);

    @Query("select s from Student s where s.firstName = ?1")
    Student getStudentByEmailId(String emailId);

    @Query(
            value = "select * from student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailIdNative(String emailId);

    @Query(
            value = "select * from student s where s.email_address = :emailIdPassed",
            nativeQuery = true
    )
    Student getStudentByEmailIdNativeNamedParam(
            @Param("emailIdPassed") String emailId
    );

    @Modifying
    @Transactional
    @Query(
            value = "update student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentByEmailId(String firstName, String emailId);

}
