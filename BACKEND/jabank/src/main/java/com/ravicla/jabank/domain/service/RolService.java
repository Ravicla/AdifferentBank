package com.ravicla.jabank.domain.service;

import com.ravicla.jabank.domain.Rol;
import com.ravicla.jabank.domain.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {

  @Autowired
  private RolRepository rolRepository;

  public List<Rol> getAll(){
    List<Rol> rolGetAll = rolRepository.getAll();
    return (List<Rol>) rolGetAll;
  }

  public Optional<Rol> getRol(int rolId){
    Optional<Rol> rol = rolRepository.getRol(rolId);
    return (Optional<Rol>) rol;
  }

  public Rol save(Rol rol){
    Rol rolSave = rolRepository.save(rol);
    return rolSave;
  }

  public boolean delete(int rolId){
    return getRol(rolId).map(rol -> {
      rolRepository.delete(rolId);
      return true;
    }).orElse(false);
  }

}
