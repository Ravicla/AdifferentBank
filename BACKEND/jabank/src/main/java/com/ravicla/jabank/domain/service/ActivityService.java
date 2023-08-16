package com.ravicla.jabank.domain.service;

import com.ravicla.jabank.domain.Activity;
import com.ravicla.jabank.domain.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {
  @Autowired
  private ActivityRepository activityRepository;

  public List<Activity> getAll(){
    List<Activity> activityGetAll = activityRepository.getAll();
    return (List<Activity>) activityGetAll;
  }

  public Optional<Activity> getActivity(int activityId){
    Optional<Activity> activity = activityRepository.getActivity(activityId);
    return (Optional<Activity>) activity;
  }

  public Activity save(Activity activity){
    Activity activitySave = activityRepository.save(activity);
    return activitySave;
  }

  public boolean delete(int activityId){
    return getActivity(activityId).map(activity -> {
      activityRepository.delete(activityId);
      return true;
    }).orElse(false);
  }
}
