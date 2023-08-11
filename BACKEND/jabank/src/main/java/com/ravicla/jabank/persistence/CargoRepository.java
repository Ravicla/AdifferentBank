package com.ravicla.jabank.persistence;

import com.ravicla.jabank.domain.Rol;
import com.ravicla.jabank.domain.repository.RolRepository;
import com.ravicla.jabank.persistence.crud.CargoCrudRepository;
import com.ravicla.jabank.persistence.entity.Cargo;
import com.ravicla.jabank.persistence.mapper.RolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class CargoRepository implements RolRepository {
  @Autowired
  private CargoCrudRepository cargoCrudRepository;
  @Autowired
  private RolMapper rolMapper;

  @Override
  public List<Rol> getAll() {
    List<Cargo>cargos = (List<Cargo>) cargoCrudRepository.findAll();
    return rolMapper.toRols(cargos);
  }

  @Override
  public Optional<Rol> getRol(int rolId) {
    return cargoCrudRepository.findById(rolId).map(cargo -> rolMapper.toRol (cargo));
  }

  @Override
  public Rol save(Rol rol) {
    Cargo cargo = rolMapper.toCargo(rol);
    return rolMapper.toRol(cargoCrudRepository.save(cargo));
  }

  @Override
  public void delete(int cargoId) {
    cargoCrudRepository.deleteById(cargoId);
  }
}
