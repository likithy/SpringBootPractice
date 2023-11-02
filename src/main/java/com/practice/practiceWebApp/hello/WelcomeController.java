package com.practice.practiceWebApp.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("userName")
public class WelcomeController {
  private Logger logger = LoggerFactory.getLogger(getClass());
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String goToWelcomePage(ModelMap map) {
    map.addAttribute("userName",getLoggedInUserName());
    return "welcome";
  }
  private String getLoggedInUserName(){
    return SecurityContextHolder.getContext().getAuthentication().getName();
  }
}
