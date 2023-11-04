package com.practice.practiceWebApp.todo;

import com.practice.practiceWebApp.model.ToDoRepository;
import jakarta.validation.Valid;
import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@SessionAttributes("userName")
@Controller
public class ToDoController {
  private ToDoService toDoService;
  private ToDoRepository repository;
  private Logger logger = LoggerFactory.getLogger(getClass());

  public ToDoController(ToDoService toDoService, ToDoRepository repository) {
    this.toDoService = toDoService;
    this.repository = repository;
  }

  @RequestMapping(value = "list-todos")
  public String listToDos(ModelMap map) {
    map.put("toDos", repository.findAll());
    return "listToDos";
  }

  private String getLoggedInUserName() {
    return SecurityContextHolder.getContext().getAuthentication().getName();
  }

  @RequestMapping(value = "add-todo", method = RequestMethod.GET)
  public String viewNewToDoPage(ModelMap map) {
    map.put(
        "toDo",
        new ToDo( map.get("userName").toString(), "", LocalDate.now().plusYears(1), false));
    return "addToDo";
  }

  @RequestMapping(value = "delete-todo")
  public String deleteToDo(@RequestParam String description) {
    //toDoService.removeById(id);
    return "redirect:list-todos";
  }

  @RequestMapping(value = "update-todo", method = RequestMethod.GET)
  public String showUpdateToDo(ModelMap map, @RequestParam String name) {
    //ToDo todo = toDoService.findById(id);
    //map.put("toDo", todo);
    return "addToDo";
  }

  @RequestMapping(value = "add-todo", method = RequestMethod.POST)
  public String addNewToDo(ModelMap map, @Valid ToDo toDo, BindingResult result) {
    if (result.hasErrors()) {
      return "addToDo";
    }
    toDoService.addNewToDo(
        map.get("userName").toString(), toDo.getDescription(), toDo.getTargetDate(), false);
    return "redirect:list-todos";
  }

  @RequestMapping(value = "update-todo", method = RequestMethod.POST)
  public String updateToDo(ModelMap map, @Valid ToDo toDo, BindingResult result) {
    if (result.hasErrors()) {
      return "addToDo";
    }
    toDo.setUserName(map.get("userName").toString());
    toDoService.updateToDo(toDo);
    return "redirect:list-todos";
  }
}
