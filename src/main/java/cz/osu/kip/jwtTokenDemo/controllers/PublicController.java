package cz.osu.kip.jwtTokenDemo.controllers;

import cz.osu.kip.jwtTokenDemo.services.AppUserService;
import cz.osu.kip.jwtTokenDemo.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

  @Autowired
  private AppUserService appUserService;

  @Autowired
  private JwtService jwtService;

  @Autowired
  private AuthenticationManager authenticationManager;

  @GetMapping
  public String get() {
    return "public get ok";
  }

  @PostMapping
  public String post() {
    return "public post ok";
  }

  @GetMapping(path = "/login")
  public String login(@RequestParam String email, @RequestParam String password) {
    Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(email, password));
    if (authentication.isAuthenticated()) {
      return jwtService.generateToken(email);
    } else {
      throw new UsernameNotFoundException("invalid user request !");
    }
  }
}
