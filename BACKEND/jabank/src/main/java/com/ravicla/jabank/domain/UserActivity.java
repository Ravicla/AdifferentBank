package com.ravicla.jabank.domain;

import java.util.List;

public class UserActivity extends User {

  private List<Activity> activityList;

  public List<Activity> getActivityList() {
    return activityList;
  }

  public void setActivityList(List<Activity> activityList) {
    this.activityList = activityList;
  }
}
