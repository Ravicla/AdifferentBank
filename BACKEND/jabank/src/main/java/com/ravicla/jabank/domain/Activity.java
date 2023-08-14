package com.ravicla.jabank.domain;

import javax.persistence.Column;
import java.util.Date;

public class Activity {
  private int activityId;
  private String activity;
  private double cost;
  private String description;
  private Date date;
  private int userId;

  public int getActivityId() {
    return activityId;
  }

  public void setActivityId(int activityId) {
    this.activityId = activityId;
  }

  public String getActivity() {
    return activity;
  }

  public void setActivity(String activity) {
    this.activity = activity;
  }

  public double getCost() {
    return cost;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }
}
