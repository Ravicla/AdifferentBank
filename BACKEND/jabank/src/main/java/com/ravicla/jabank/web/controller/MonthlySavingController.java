package com.ravicla.jabank.web.controller;

import com.ravicla.jabank.domain.MonthlySaving;
import com.ravicla.jabank.domain.Rol;
import com.ravicla.jabank.domain.service.MonthlySavingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("monthlySavings")
public class MonthlySavingController {
  @Autowired
  private MonthlySavingService monthlySavingService;

  @GetMapping("/all")
  public ResponseEntity<List<MonthlySaving>> getAll() {
    return new ResponseEntity<>(monthlySavingService.getAll(), HttpStatus.OK);
  }
  @GetMapping("/{id}")
  public ResponseEntity<MonthlySaving> getMonthlySavingById(@PathVariable("id") int monthlySavingId) {
    Optional<MonthlySaving> monthlySavingOptional = monthlySavingService.getMonthlySaving(monthlySavingId);
    if (monthlySavingOptional.isPresent()) {
      MonthlySaving monthlySaving = monthlySavingOptional.get();
      return new ResponseEntity<>(monthlySaving, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/save")
  public ResponseEntity<MonthlySaving> save (@RequestBody MonthlySaving monthlySaving){
    return new ResponseEntity<>(monthlySavingService.save(monthlySaving), HttpStatus.CREATED);
  }

  @PutMapping("/update")
  public ResponseEntity<MonthlySaving> update (@RequestBody MonthlySaving monthlySaving){
    return new ResponseEntity<>(monthlySavingService.save(monthlySaving), HttpStatus.CREATED);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity delete(@PathVariable("id") int monthlySavingId){
    if(monthlySavingService.delete(monthlySavingId)){
      return new ResponseEntity<>(HttpStatus.OK);
    }else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

}
