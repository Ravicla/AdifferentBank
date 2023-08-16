package com.ravicla.jabank.persistence.crud;

import com.ravicla.jabank.persistence.entity.Actividad;
import com.ravicla.jabank.persistence.entity.AhorroMensual;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AhorroMensualCrudRepository extends CrudRepository<AhorroMensual, Integer> {
  Optional<List<AhorroMensual>> findByIdUsuario(int idUsuario);
}
