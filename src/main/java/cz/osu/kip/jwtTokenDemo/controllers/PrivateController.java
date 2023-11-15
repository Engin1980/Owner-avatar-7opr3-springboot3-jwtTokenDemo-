package cz.osu.kip.jwtTokenDemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private")
public class PrivateController {

  @GetMapping
  public String get() {
    return "private get ok";
  }

  @PostMapping
  public String post() {
    return "private post ok";
  }
}
