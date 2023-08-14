package com.ravicla.jabank.persistence.entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Table(name = "ahorro_mensual")
public class AhorroMensual {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ahorro_mensual_id")
  private Integer idAhorroMensual;
  private Date fecha;
  private Double valor;
  @Column(name = "usuario_id")
  private Integer idUsuario;

  public Integer getIdAhorroMensual() {
    return idAhorroMensual;
  }

  public void setIdAhorroMensual(Integer idAhorroMensual) {
    this.idAhorroMensual = idAhorroMensual;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public Integer getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
  }
}
