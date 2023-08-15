package com.ravicla.jabank.domain.repository;

import com.ravicla.jabank.domain.Activity;

import java.util.List;
import java.util.Optional;

public interface ActivityRepository {
  List<Activity> getAll();
  Optional<Activity> getActivity(int activityId);
  Optional<List<Activity>> getUserActivities(int userId);
  Activity save(Activity activity);
  void delete(int activityId);
}
