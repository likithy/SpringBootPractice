package com.practice.learnspringboot;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {
  // courses: details id,name , author
  @RequestMapping("/courses")
  public List<Course> retriveAllCourses() {
    return Arrays.asList(
        new Course(1, "Learn AWS", "Likith"),
        new Course(2, "Learn DEVOPS", "Likith"),
        new Course(4, "Learn AWS", "Likith"));
  }
}
