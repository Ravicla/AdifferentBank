package com.ravicla.jabank.persistence;

import com.ravicla.jabank.domain.TypeActivity;
import com.ravicla.jabank.domain.repository.TypeActivityRepository;
import com.ravicla.jabank.persistence.crud.TipoActividadCrudRepository;
import com.ravicla.jabank.persistence.entity.Cargo;
import com.ravicla.jabank.persistence.entity.TipoActividad;
import com.ravicla.jabank.persistence.mapper.TypeActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class TipoActividadRepository implements TypeActivityRepository {
  @Autowired
  private TipoActividadCrudRepository tipoActividadCrudRepository;
  @Autowired
  private TypeActivityMapper typeActivityMapper;

  @Override
  public List<TypeActivity> getAll() {
    List<TipoActividad>tipoActividads = (List<TipoActividad>) tipoActividadCrudRepository.findAll();
    return typeActivityMapper.toTypeActivitys(tipoActividads);
  }

  @Override
  public Optional<TypeActivity> getTypeActivity(int typeActivityId) {
    return tipoActividadCrudRepository.findById(typeActivityId).map(tipoActividad -> typeActivityMapper.toTypeActivity(tipoActividad));

  }

  @Override
  public TypeActivity save(TypeActivity typeActivity) {
    TipoActividad tipoActividad = typeActivityMapper.toTipoActividad(typeActivity);
    return typeActivityMapper.toTypeActivity(tipoActividadCrudRepository.save(tipoActividad));
  }

  @Override
  public void delete(int tipoActividadId) {
    tipoActividadCrudRepository.deleteById(tipoActividadId);
  }
}
