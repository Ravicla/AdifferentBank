package com.ravicla.jabank.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "tipo_actividad")
public class TipoActividad {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "tipo_actividad_id")
  private Integer idTipoActividad;
  private String actividad;

  public Integer getIdTipoActividad() {
    return idTipoActividad;
  }

  public void setIdTipoActividad(Integer idTipoActividad) {
    this.idTipoActividad = idTipoActividad;
  }

  public String getActividad() {
    return actividad;
  }

  public void setActividad(String actividad) {
    this.actividad = actividad;
  }
}
