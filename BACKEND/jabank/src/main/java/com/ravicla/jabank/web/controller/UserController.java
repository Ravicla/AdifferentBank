package com.ravicla.jabank.web.controller;

import com.ravicla.jabank.domain.Login;
import com.ravicla.jabank.domain.User;
import com.ravicla.jabank.domain.UserActivity;
import com.ravicla.jabank.domain.UserMonthlySaving;
import com.ravicla.jabank.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping("/all")
  public ResponseEntity<List<User>> getAll(){
    return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable("id") int userId) {
    Optional<User> userOptional = userService.getUser(userId);
    if (userOptional.isPresent()) {
      User user = userOptional.get();
      return new ResponseEntity<>(user, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @PostMapping("/save")
  public ResponseEntity<User> save (@RequestBody User user){
    return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
  }

  @PutMapping("/update")
  public ResponseEntity<User> update (@RequestBody User user){
    return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity delete(@PathVariable("id") int userId){
    //log.info("IN: " + jsonUtil.toJson(userId));
    if(userService.delete(userId)){
      return new ResponseEntity<>(HttpStatus.OK);
    }else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/login")
  public ResponseEntity<User> login (@RequestBody Login login){
      Optional<User> userOptional = userService.getLogin(login.getEmailAddress(), login.getIdentificationNumber());
    if (userOptional.isPresent()) {
      User user= userOptional.get();
      return new ResponseEntity<>(user, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/{id}/activities")
  public ResponseEntity<UserActivity> getUserActivities(@PathVariable("id") int userId) {
    Optional<UserActivity> userOptional = userService.getUserActivities(userId);
    if (userOptional.isPresent()) {
      UserActivity user = userOptional.get();
      return new ResponseEntity<>(user, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/{id}/monthlySavings")
  public ResponseEntity<UserMonthlySaving> getUserMonthlySaving(@PathVariable("id") int userId) {
    Optional<UserMonthlySaving> userOptional = userService.getUserMonthlySaving(userId);
    if (userOptional.isPresent()) {
      UserMonthlySaving user = userOptional.get();
      return new ResponseEntity<>(user, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

}
