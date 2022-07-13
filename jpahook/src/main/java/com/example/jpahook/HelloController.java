package com.example.jpahook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

  @GetMapping("hello")
  public String helllo(Model model) {
    model.addAttribute("data", "helllo!!!");
    return "hello";
  }
}
