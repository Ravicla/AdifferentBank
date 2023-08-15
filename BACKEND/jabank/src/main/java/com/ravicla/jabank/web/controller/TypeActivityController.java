package com.ravicla.jabank.web.controller;

import com.ravicla.jabank.domain.Rol;
import com.ravicla.jabank.domain.TypeActivity;
import com.ravicla.jabank.domain.service.TypeActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/typeActivitys")
public class TypeActivityController {
  @Autowired
  private TypeActivityService typeActivityService;

  @GetMapping("/all")
  public ResponseEntity<List<TypeActivity>> getAll(){
    return new ResponseEntity<>(typeActivityService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<TypeActivity> getTypeActivityById(@PathVariable("id") int typeActivityId) {
    Optional<TypeActivity> typeActivityOptional = typeActivityService.getTypeActivity(typeActivityId);
    if (typeActivityOptional.isPresent()) {
      TypeActivity typeActivity = typeActivityOptional.get();
      return new ResponseEntity<>(typeActivity, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/save")
  public ResponseEntity<TypeActivity> save (@RequestBody TypeActivity typeActivity){
    return new ResponseEntity<>(typeActivityService.save(typeActivity), HttpStatus.CREATED);
  }

  @PutMapping("/update")
  public ResponseEntity<TypeActivity> update (@RequestBody TypeActivity typeActivity){
    return new ResponseEntity<>(typeActivityService.save(typeActivity), HttpStatus.CREATED);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity delete(@PathVariable("id") int typeActivityId){
    if(typeActivityService.delete(typeActivityId)){
      return new ResponseEntity<>(HttpStatus.OK);
    }else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
