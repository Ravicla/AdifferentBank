package com.ravicla.jabank.domain.repository;


import com.ravicla.jabank.domain.Rol;

import java.util.List;
import java.util.Optional;

public interface RolRepository {
  List<Rol> getAll();
  Optional<Rol> getRol(int rolId);
  Rol save(Rol rol);
  void delete(int rolId);

}
