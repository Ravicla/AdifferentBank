package com.ravicla.jabank.persistence.crud;

import com.ravicla.jabank.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer> {

  Optional<Usuario> findByCorreoAndCedula(String correo, String cedula);
}
