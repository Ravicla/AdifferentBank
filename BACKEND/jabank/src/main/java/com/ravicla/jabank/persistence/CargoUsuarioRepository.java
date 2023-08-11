package com.ravicla.jabank.persistence;

import com.ravicla.jabank.domain.RolUser;
import com.ravicla.jabank.domain.repository.RolUserRepository;
import com.ravicla.jabank.persistence.crud.CargoUsuarioCrudRepository;
import com.ravicla.jabank.persistence.entity.Cargo;
import com.ravicla.jabank.persistence.entity.CargoUsuario;
import com.ravicla.jabank.persistence.mapper.RolUserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CargoUsuarioRepository implements RolUserRepository {

  @Autowired
  private CargoUsuarioCrudRepository cargoUsuarioCrudRepository;
  @Autowired
  private RolUserMapper rolUserMapper;
  @Override
  public List<RolUser> getAll() {
    List<CargoUsuario>cargoUsuarios = (List<CargoUsuario>) cargoUsuarioCrudRepository.findAll();
    return rolUserMapper.toRolUsers(cargoUsuarios);
  }

  @Override
  public Optional<RolUser> getRolUser(int rolUserId) {
    return cargoUsuarioCrudRepository.findById(rolUserId).map(cargoUsuario -> rolUserMapper.toRolUser (cargoUsuario));

  }

  @Override
  public RolUser save(RolUser rolUser) {
    CargoUsuario cargoUsuario = rolUserMapper.toCargoUsuario(rolUser);
    return rolUserMapper.toRolUser(cargoUsuarioCrudRepository.save(cargoUsuario));
  }

  @Override
  public void delete(int cargoUsuarioId) {
    cargoUsuarioCrudRepository.deleteById(cargoUsuarioId);
  }
}
