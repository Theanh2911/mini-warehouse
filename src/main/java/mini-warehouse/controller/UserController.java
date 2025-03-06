package week1.internJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import week1.internJava.entity.User;

import week1.internJava.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User savedUser = userService.addUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @PutMapping ("/updateUserViaId/{id}")
    public ResponseEntity<User> updateUserInfo(@PathVariable int id, @RequestBody User user) {
        User updatedUser = userService.updateUserInfo(id, user);
        return ResponseEntity.ok(updatedUser);
    }

    @PutMapping ("/updateUserPasswordViaId/{id}")
    public ResponseEntity<User> updateUserPassword(@PathVariable int id, @RequestBody User password) {
        User updatedUser = userService.updateUserInfo(id, password);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/deleteUserViaId/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getUserViaId/{id}")
    public ResponseEntity<User> getStudentById(@PathVariable int id) {
        Optional<User> user = Optional.ofNullable(userService.getUserViaId(id));
        return ResponseEntity.of(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String userName, @RequestParam String passWord) {
        if (userService.login(userName, passWord)) {
            return ResponseEntity.ok("Login successful");
        }
        return ResponseEntity.status(401).body("Invalid username or password");
    }

//    @GetMapping("/getStudentViaName/{name}")
//    public ResponseEntity<List<Student>> getStudentsByName(@PathVariable String name) {
//
//        List<Student> students = studentService.findStudentsByName(name);
//
//        if (students.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.ok(students);
//    }

}
