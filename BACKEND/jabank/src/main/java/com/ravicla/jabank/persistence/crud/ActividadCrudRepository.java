package com.ravicla.jabank.persistence.crud;

import com.ravicla.jabank.persistence.entity.Actividad;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ActividadCrudRepository extends CrudRepository<Actividad, Integer> {
  Optional<List<Actividad>> findByIdUsuario(int idUsuario);
}
