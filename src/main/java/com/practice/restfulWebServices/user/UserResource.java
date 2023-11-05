package com.practice.restfulWebServices.user;

import java.net.URI;
import java.util.List;

import com.practice.restfulWebServices.errorHandling.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
  private UserDAO userDAO;

  public UserResource(UserDAO userDAO) {
    this.userDAO = userDAO;
  }

  @GetMapping(path = "/users")
  public List<User> getAllUsers() {
    return userDAO.findAll();
  }

  @GetMapping(path = "/users/{id}")
  public User getUserById(@PathVariable String id) {
    User user =userDAO.findById(id);
    if(user==null){
      throw new UserNotFoundException("id : "+id);
    }
    return user;
  }
  @DeleteMapping(path = "/users/{id}")
  public void deleteUserById(@PathVariable String id) {
    User user =userDAO.findById(id);
    if(user==null){
      throw new UserNotFoundException("id : "+id);
    }
    userDAO.deleteById(id);
  }

  @PostMapping(path = "/users")
  public ResponseEntity<User> createNewUser(@Valid @RequestBody User user) {
    userDAO.createNewUser(user);
    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(user.getId())
            .toUri();
    return ResponseEntity.created(location).build();
  }
}
