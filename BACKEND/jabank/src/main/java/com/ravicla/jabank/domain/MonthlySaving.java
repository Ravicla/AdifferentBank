package com.ravicla.jabank.domain;

import javax.persistence.Column;
import javax.xml.crypto.Data;
import java.util.Date;

public class MonthlySaving {
  private int monthlySavingId;
  private Date date;
  private Double cost;
  private int userId;

  public int getMonthlySavingId() {
    return monthlySavingId;
  }

  public void setMonthlySavingId(int monthlySavingId) {
    this.monthlySavingId = monthlySavingId;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Double getCost() {
    return cost;
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }
}
