package week1.internJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import week1.internJava.entity.Student;
import week1.internJava.service.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student savedStudent = studentService.addStudent(student);
        return ResponseEntity.ok(savedStudent);
    }

    @PutMapping ("/updateStudentViaId/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable String id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/deleteStudentViaId/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getStudentViaId/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {
        Optional<Student> student = Optional.ofNullable(studentService.getStudentViaId(id));
        return ResponseEntity.of(student);
    }

    @GetMapping("/getStudentViaName/{name}")
    public ResponseEntity<List<Student>> getStudentsByName(@PathVariable String name) {

        List<Student> students = studentService.findStudentsByName(name);

        if (students.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(students);
    }

    @GetMapping("/getTop3GPA")
    public ResponseEntity<List<Student>> getTop3Students() {
        return ResponseEntity.ok(studentService.getTop3StudentsByGPA());
    }
}
