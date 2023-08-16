package com.ravicla.jabank.web.controller;

import com.ravicla.jabank.domain.Activity;
import com.ravicla.jabank.domain.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/activities")
public class ActivityController {
  @Autowired
  private ActivityService activityService;

  @GetMapping("/all")
  public ResponseEntity<List<Activity>> getAll(){
    return new ResponseEntity<>(activityService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Activity> getActivityById(@PathVariable("id") int activityId) {
    Optional<Activity> activityOptional = activityService.getActivity(activityId);
    if (activityOptional.isPresent()) {
      Activity activity = activityOptional.get();
      return new ResponseEntity<>(activity, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/save")
  public ResponseEntity<Activity> save (@RequestBody Activity activity){
    return new ResponseEntity<>(activityService.save(activity), HttpStatus.CREATED);
  }

  @PutMapping("/update")
  public ResponseEntity<Activity> update (@RequestBody Activity activity){
    return new ResponseEntity<>(activityService.save(activity), HttpStatus.CREATED);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity delete(@PathVariable("id") int activityId){
    if(activityService.delete(activityId)){
      return new ResponseEntity<>(HttpStatus.OK);
    }else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
