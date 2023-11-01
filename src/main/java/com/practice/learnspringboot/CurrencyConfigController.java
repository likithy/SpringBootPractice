package com.practice.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigController {
  // courses: details id,name , author
  @Autowired
  private CurrencyServiceConfig config;
  @RequestMapping("/currency-config")
  public CurrencyServiceConfig retriveAllCourses() {
    return config;
  }
}
