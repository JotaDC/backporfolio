package com.argentinaprograma.backend.security.controller;

import javax.servlet.http.HttpServletRequest;

import lombok.RequiredArgsConstructor;
import com.argentinaprograma.backend.security.model.AppUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.argentinaprograma.backend.security.dto.UserDataDTO;
import com.argentinaprograma.backend.security.dto.UserResponseDTO;
import com.argentinaprograma.backend.security.service.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/users")
//@Api(tags = "users")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;
  private final ModelMapper modelMapper;
  
  @PostMapping("/signin")
  public String login(@RequestBody UserDataDTO user){
    return userService.signin(user.getUsername(), user.getPassword());
    
  }

  @PostMapping("/signup")
  public String signup(@RequestBody UserDataDTO user) {
    return userService.signup(modelMapper.map(user, AppUser.class));
  }

  @DeleteMapping(value = "/{username}")
  //@PreAuthorize("hasRole('ROLE_ADMIN')")
  public String delete(@PathVariable String username) {
    userService.delete(username);
    return username;
  }

  @GetMapping(value = "/{username}")
  //@PreAuthorize("hasRole('ROLE_ADMIN')")
  public UserResponseDTO search(@PathVariable String username) {
    return modelMapper.map(userService.search(username), UserResponseDTO.class);
  }

  @GetMapping(value = "/me")
  //@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
  public UserResponseDTO whoami(HttpServletRequest req) {
    return modelMapper.map(userService.whoami(req), UserResponseDTO.class);
  }

  @GetMapping("/refresh")
  //PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
  public String refresh(HttpServletRequest req) {
    return userService.refresh(req.getRemoteUser());
  }

}
