package com.practice.practiceWebApp.model;

import com.practice.practiceWebApp.todo.ToDo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends MongoRepository<ToDo, String> {

    public List<ToDo> findByUserName(String userName);
}
