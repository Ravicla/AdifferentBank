package com.ravicla.jabank.domain.repository;

import com.ravicla.jabank.domain.RolUser;
import com.ravicla.jabank.domain.TypeActivity;

import java.util.List;
import java.util.Optional;

public interface TypeActivityRepository {
  List<TypeActivity> getAll();
  Optional<TypeActivity> getTypeActivity(int typeActivityId);
  TypeActivity save(TypeActivity typeActivity);
  void delete(int typeActivityId);
}
