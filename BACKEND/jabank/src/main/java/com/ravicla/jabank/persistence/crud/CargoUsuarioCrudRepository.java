package com.ravicla.jabank.persistence.crud;

import com.ravicla.jabank.persistence.entity.CargoUsuario;
import com.ravicla.jabank.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CargoUsuarioCrudRepository extends CrudRepository <CargoUsuario, Integer> {
  List<CargoUsuario> findByIdUsuario(int idUsuario);
}
