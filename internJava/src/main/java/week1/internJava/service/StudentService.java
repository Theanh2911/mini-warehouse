package week1.internJava.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import week1.internJava.entity.Student;
import week1.internJava.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(String id, Student student) {
        Student existingStudent = studentRepository.findStudentById(id);
        existingStudent.setName(student.getName());
        existingStudent.setAddress(student.getAddress());
        existingStudent.setGpa(student.getGpa());
        return studentRepository.save(existingStudent);
    }

    @Transactional
    public void deleteStudent(String id) {
        studentRepository.deleteStudentById(id);
    }

    public Student getStudentViaId(String id) {
        return studentRepository.findStudentById(id);
    }

    public List<Student> findStudentsByName(String name) {
        return studentRepository.findStudentByName(name);
    }

    public List<Student> getTop3StudentsByGPA() {
        return studentRepository.findTop3ByOrderByGpaDesc();
    }
}
