package com.ravicla.jabank.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "cargos_usuarios")
public class CargoUsuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "cargo_usuario_id")
  private Integer idCargoUsuario;
  @Column(name = "cargo_id")
  private Integer idCargo;
  @Column(name = "usuario_id")
  private Integer idUsuario;

  public Integer getIdCargoUsuario() {
    return idCargoUsuario;
  }

  public void setIdCargoUsuario(Integer idCargoUsuario) {
    this.idCargoUsuario = idCargoUsuario;
  }

  public Integer getIdCargo() {
    return idCargo;
  }

  public void setIdCargo(Integer idCargo) {
    this.idCargo = idCargo;
  }

  public Integer getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
  }
}
