package com.practice.learnjpaandhibernate.course;

import com.practice.learnjpaandhibernate.course.springdatajpa.CourseSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
  //@Autowired private CourseJdbcRepository repository;
//  @Autowired private CourseJpaRepository repository;

  @Autowired private CourseSpringDataRepository repository;
  @Override
  public void run(String... args) throws Exception {
    repository.save(new Course(1,"Learn AWS now","Likith"));
    repository.save(new Course(2,"Learn Devops","Likith"));
    repository.save(new Course(3,"Learn Azure","Likith"));
    repository.deleteById(2l);
    System.out.println(repository.findById(1l));
    System.out.println(repository.findById(3l));
    System.out.println(repository.findByAuthor("Likith"));
    System.out.println(repository.findByAuthor(""));
    System.out.println(repository.findByName("Learn Azure"));
    repository.findAll().forEach(System.out::println);
  }
}
