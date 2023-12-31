package com.ravicla.jabank.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
  private int userId;
  private String identificationNumber;
  private String firstName;
  private String lastName;
  private Date birthdate;
  private String emailAddress;
  private String phoneNumber;
  private boolean status;

  private List<Rol> rol;


  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getIdentificationNumber() {
    return identificationNumber;
  }

  public void setIdentificationNumber(String identificationNumber) {
    this.identificationNumber = identificationNumber;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Date getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(Date birthdate) {
    this.birthdate = birthdate;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public List<Rol> getRol() {
    return rol;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public void setRol(List<Rol> rol) {
    this.rol = rol;
  }
}
