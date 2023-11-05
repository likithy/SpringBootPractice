package com.practice.restfulWebServices.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class UserDAO {
    private UserRepository repository;

    public UserDAO(UserRepository repository) {
        this.repository = repository;
    }

    void addUser(String name, LocalDate birthDate){
        repository.insert(new User(name,birthDate));
    }

    List<User> findAll(){
        return repository.findAll();
    }

    User findById(String id){
        return repository.findById(id).orElse(null);
    }

    void deleteById(String id){
        repository.deleteById(id);
    }

    void createNewUser(User user){
        repository.insert(user);
    }

}
