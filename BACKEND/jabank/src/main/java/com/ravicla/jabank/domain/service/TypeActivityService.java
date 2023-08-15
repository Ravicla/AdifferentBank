package com.ravicla.jabank.domain.service;

import com.ravicla.jabank.domain.TypeActivity;
import com.ravicla.jabank.domain.repository.TypeActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeActivityService {
  @Autowired
  private TypeActivityRepository typeActivityRepository;

  public List<TypeActivity> getAll(){
    List<TypeActivity> typeActivityGetAll = typeActivityRepository.getAll();
    return (List<TypeActivity>) typeActivityGetAll;
  }

  public Optional<TypeActivity> getTypeActivity(int typeActivityId){
    Optional<TypeActivity> typeActivity = typeActivityRepository.getTypeActivity(typeActivityId);
    return (Optional<TypeActivity>) typeActivity;
  }

  public TypeActivity save(TypeActivity typeActivity){
    TypeActivity typeActivitySave = typeActivityRepository.save(typeActivity);
    return typeActivitySave;
  }

  public boolean delete(int typeActivityId){
    return getTypeActivity (typeActivityId).map(typeActivity -> {
      typeActivityRepository.delete(typeActivityId);
      return true;
    }).orElse(false);
  }
}
