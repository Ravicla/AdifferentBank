package com.ravicla.jabank.web.controller;

import com.ravicla.jabank.domain.Rol;
import com.ravicla.jabank.domain.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/roles")
public class RolController {
  @Autowired
  private RolService rolService;

  @GetMapping("/all")
  public ResponseEntity<List<Rol>> getAll(){
    return new ResponseEntity<>(rolService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Rol> getRolById(@PathVariable("id") int rolId) {
    Optional<Rol> rolOptional = rolService.getRol(rolId);
    if (rolOptional.isPresent()) {
      Rol rol = rolOptional.get();
      return new ResponseEntity<>(rol, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/save")
  public ResponseEntity<Rol> save (@RequestBody Rol rol){
    return new ResponseEntity<>(rolService.save(rol), HttpStatus.CREATED);
  }

  @PutMapping("/update")
  public ResponseEntity<Rol> update (@RequestBody Rol rol){
    return new ResponseEntity<>(rolService.save(rol), HttpStatus.CREATED);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity delete(@PathVariable("id") int rolId){
    if(rolService.delete(rolId)){
      return new ResponseEntity<>(HttpStatus.OK);
    }else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
