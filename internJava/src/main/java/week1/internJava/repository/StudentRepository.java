package week1.internJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import week1.internJava.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    Student findStudentById(String id);

    List<Student> findStudentByName(String name);

    void deleteStudentById(String id);

    List<Student> findTop3ByOrderByGpaDesc();

}
