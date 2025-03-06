package week1.internJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import week1.internJava.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findUserById(int id);

    List<User> findUserByFullName(String fullName);

    Optional<User> findUserByUserName(String userName);

    void deleteUserById(int id);

}
