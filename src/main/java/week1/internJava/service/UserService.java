package week1.internJava.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import week1.internJava.entity.User;
import week1.internJava.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUserInfo(int id, User user) {
        User existingUser = userRepository.findUserById(id);
        existingUser.setFullName(user.getFullName());
        existingUser.setUserName(user.getUserName());
        return userRepository.save(existingUser);
    }

    public User updatePassword(int id, String password) {
        User existingUser = userRepository.findUserById(id);
        existingUser.setPassWord(existingUser.getPassWord().concat(password));
        return userRepository.save(existingUser);
    }

    @Transactional
    public void deleteUserById(int id) {
        userRepository.deleteUserById(id);
    }

    public User getUserViaId(int id) {
        return userRepository.findUserById(id);
    }

    public List<User> findStudentsByName(String fullName) {
        return userRepository.findUserByFullName(fullName);
    }

    public boolean login(String userName, String passWord) {
        return userRepository.findUserByUserName(userName)
                .map(user -> passWord.equals(user.getPassWord()))
                .orElse(false);
    }

}
