package com.ravicla.jabank.domain.repository;

import com.ravicla.jabank.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
  List<User> getAll();
  Optional<User> getUser(int userId);
  Optional<User> getLogin(String correo, String cedula);
  User save(User user);
  void delete(int userId);
}
