package com.practice.practiceWebApp.todo;

import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ToDo {
  @Id public String id;
  private String userName;

  @Size(min = 4, message = "Enter characters minimum 4")
  private String description;

  private LocalDate targetDate;
  private boolean done;

  public ToDo(String userName, String description, LocalDate targetDate, boolean done) {
    this.userName = userName;
    this.description = description;
    this.targetDate = targetDate;
    this.done = done;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDate getTargetDate() {
    return targetDate;
  }

  public void setTargetDate(LocalDate targetDate) {
    this.targetDate = targetDate;
  }

  public boolean isDone() {
    return done;
  }

  public void setDone(boolean done) {
    this.done = done;
  }
}
