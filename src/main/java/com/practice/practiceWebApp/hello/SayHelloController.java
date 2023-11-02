package com.practice.practiceWebApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

  @RequestMapping("say-hello")
  @ResponseBody
  public String sayHello() {
    return "Hi, Sup ?";
  }
  @RequestMapping("say-hello-jsp")
  public String sayHelloJsp() {
    return "/sayHello";
  }

  @RequestMapping("say-hello-html")
  @ResponseBody
  public String sayHelloHtml() {
    return """
<html>
<head><title> HTML PAGE ONE</title></head>
<body>
<h1>MY HTML BODY
</body>
</html>
""";
  }
}
