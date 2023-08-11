package com.ravicla.jabank.persistence.crud;

import com.ravicla.jabank.persistence.entity.Cargo;
import org.springframework.data.repository.CrudRepository;

public interface CargoCrudRepository extends CrudRepository<Cargo, Integer> {
}
