package com.ravicla.jabank.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "cargo")
public class Cargo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "cargo_id")
  private Integer idCargo;
  private String cargo;

  public Integer getIdCargo() {
    return idCargo;
  }

  public void setIdCargo(Integer idCargo) {
    this.idCargo = idCargo;
  }

  public String getCargo() {
    return cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }
}
