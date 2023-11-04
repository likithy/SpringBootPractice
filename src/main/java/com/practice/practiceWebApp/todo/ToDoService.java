package com.practice.practiceWebApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {
  private static List<ToDo> toDos = new ArrayList<>();
  static {
    toDos.add(new ToDo("Likith", "Learn Spring", LocalDate.now().plusYears(1), false));
    toDos.add(new ToDo( "Likith", "Learn Devops", LocalDate.now().plusMonths(2), false));
    toDos.add(new ToDo( "Likith", "Learn Fullstack", LocalDate.now().plusYears(4), false));
  }
  private static int countToDo = toDos.size();

  public List<ToDo> findByUserName(String userName) {
    return toDos.stream()
        .filter(toDo -> toDo.getUserName().equalsIgnoreCase(userName))
        .collect(Collectors.toList());
  }

  public void addNewToDo(String username,String description,LocalDate targetDate,Boolean isDone){
    toDos.add(new ToDo(username,description,targetDate,isDone));
  }

//  public void removeById(int id){
//    toDos.removeIf(toDo -> toDo.getId()==(id));
//  }

//  public ToDo findById(int id) {
//    return toDos.stream().filter(toDo -> toDo.getId()==id).findFirst().orElse(null);
//  }

  public void updateToDo(ToDo toDo) {
   // removeById(toDo.getId());
    toDos.add(toDo);
  }
}
