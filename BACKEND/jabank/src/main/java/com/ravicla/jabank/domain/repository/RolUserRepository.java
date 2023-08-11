package com.ravicla.jabank.domain.repository;

import com.ravicla.jabank.domain.RolUser;

import java.util.List;
import java.util.Optional;

public interface RolUserRepository {
  List<RolUser> getAll();
  Optional<RolUser> getRolUser(int rolUserId);
  RolUser save(RolUser rolUser);
  void delete(int rolUserId);
}
