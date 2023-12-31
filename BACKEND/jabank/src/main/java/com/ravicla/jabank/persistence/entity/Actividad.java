package com.ravicla.jabank.persistence.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "actividad")
public class Actividad {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "actividad_id")
  private Integer idActividad;
  private double valor;
  private String descripcion;
  private Date fecha;
  @Column(name = "usuario_id")
  private Integer idUsuario;

  @Column(name = "tipo_actividad_id")
  private Integer idTipoActividad;

  public Integer getIdActividad() {
    return idActividad;
  }

  public void setIdActividad(Integer idActividad) {
    this.idActividad = idActividad;
  }



  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public Integer getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
  }

  public Integer getIdTipoActividad() {
    return idTipoActividad;
  }

  public void setIdTipoActividad(Integer idTipoActividad) {
    this.idTipoActividad = idTipoActividad;
  }
}
