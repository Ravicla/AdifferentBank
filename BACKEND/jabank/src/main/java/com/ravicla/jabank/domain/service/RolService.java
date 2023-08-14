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
  public RolRepository rolRepository;

  public List<Rol> getAll(){
    List<Rol> rolGetAll = rolRepository.getAll();
    return (List<Rol>) rolGetAll;
  }

  public Optional<Rol> getRol(int rolId){
    Optional<Rol> rolIdOut = rolRepository.getRol(rolId);
    return (Optional<Rol>) rolIdOut;
  }

  public Rol save(Rol rol){
    Rol rolSaveOut = rolRepository.save(rol);
    return rolSaveOut;
  }

  public boolean delete(int rolId){
    return getRol(rolId).map(rol -> {
      rolRepository.delete(rolId);
      return true;
    }).orElse(false);
  }

}
