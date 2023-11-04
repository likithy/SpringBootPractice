package com.practice.practiceWebApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.practice.practiceWebApp.model.ToDoRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {
  private ToDoRepository repository;

  public ToDoService(ToDoRepository repository) {
    this.repository = repository;
  }

  public List<ToDo> findByUserName(String userName) {
    return repository.findByUserName(userName);
  }

  public void addNewToDo(String username,String description,LocalDate targetDate,Boolean isDone){
    repository.insert(new ToDo(username,description,targetDate,isDone));
  }

  public void removeById(String id){
    repository.deleteById(id);
  }

  public ToDo findById(String id) {
    return repository.findById(id).get();
      }

  public void updateToDo(ToDo toDo) {
    Optional<ToDo> todo=repository.findById(toDo.getId());
        todo.ifPresent(
            updatedToDo -> {
              updatedToDo.setDescription(toDo.getDescription());
              updatedToDo.setTargetDate(toDo.getTargetDate());
              updatedToDo.setDone(toDo.isDone());
            });
    repository.save(todo.get());
  }

  public List<ToDo> listAllTodos(){
    return repository.findAll();
  }
}
