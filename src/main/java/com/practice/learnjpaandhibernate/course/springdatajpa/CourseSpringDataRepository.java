package com.practice.learnjpaandhibernate.course.springdatajpa;

import com.practice.learnjpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataRepository extends JpaRepository<Course,Long> {
List<Course> findByAuthor(String author);
    List<Course> findByName(String name);
}
