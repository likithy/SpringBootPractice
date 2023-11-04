package com.practice.practiceWebApp.model;

import com.practice.practiceWebApp.todo.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends MongoRepository<ToDo,String> {

}
