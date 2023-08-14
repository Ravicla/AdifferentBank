package com.ravicla.jabank.persistence.crud;

import com.ravicla.jabank.persistence.entity.Actividad;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActividadCrudRepository extends CrudRepository<Actividad, Integer> {
}
