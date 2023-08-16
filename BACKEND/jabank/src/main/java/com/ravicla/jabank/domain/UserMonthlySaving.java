package com.ravicla.jabank.domain;

import java.util.List;

public class UserMonthlySaving extends User{
  private List<MonthlySaving> monthlySavingList;

  public List<MonthlySaving> getMonthlySavingList() {
    return monthlySavingList;
  }

  public void setMonthlySavingList(List<MonthlySaving> monthlySavingList) {
    this.monthlySavingList = monthlySavingList;
  }
}
