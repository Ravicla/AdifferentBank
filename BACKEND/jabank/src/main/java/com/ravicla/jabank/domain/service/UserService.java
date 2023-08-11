package com.ravicla.jabank.domain.service;

import com.ravicla.jabank.domain.Rol;
import com.ravicla.jabank.domain.RolUser;
import com.ravicla.jabank.domain.User;
import com.ravicla.jabank.domain.repository.RolRepository;
import com.ravicla.jabank.domain.repository.RolUserRepository;
import com.ravicla.jabank.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class UserService {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private RolRepository rolRepository;
  @Autowired
  private RolUserRepository rolUserRepository;


  public List<User> getAll(){
    List<User> userGetAll = userRepository.getAll();
    for (User users : userGetAll) {
      List<RolUser> rolUsers = rolUserRepository.getByIdUsuario(users.getUserId());
      List<Rol> rols = new ArrayList<>();
      for (RolUser rolUser : rolUsers) {
        Rol rol = new Rol();
        rol = rolRepository.getRol(rolUser.getRolId()).get();
        rols.add(rol);
      }
      users.setRol(rols);
    }
    return (List<User>) userGetAll;
  }

  public Optional<User> getUser(int userId){
    Optional<User> user = userRepository.getUser(userId);
    List<RolUser> rolUsers = rolUserRepository.getByIdUsuario(user.get().getUserId());
    List<Rol> rols = new ArrayList<>();
    for (RolUser rolUser : rolUsers) {
      Rol rol = new Rol();
      rol = rolRepository.getRol(rolUser.getRolId()).get();
      rols.add(rol);
      rol.setRol(rolRepository.getRol(rol.getRolId()).get().getRol());
    }
    user.get().setRol(rols);
    return (Optional<User>) user;
  }


  public Optional<User> getLogin(String correo, String cedula){
    Optional<User> user = userRepository.getLogin(correo, cedula);
    List<RolUser> rolUsers = rolUserRepository.getByIdUsuario(user.get().getUserId());
    List<Rol> rols = new ArrayList<>();
    for (RolUser rolUser : rolUsers) {
      Rol rol = new Rol();
      rol = rolRepository.getRol(rolUser.getRolId()).get();
      rols.add(rol);
    }
    user.get().setRol(rols);
    return (Optional<User>) user;
  }

  public User save(User user){
    User userSave = userRepository.save(user);
    for (Rol rol: user.getRol()) {
      RolUser rolUser = new RolUser();
      rolUser.setRolId(rol.getRolId());
      rolUser.setUserId(userSave.getUserId());
      rolUserRepository.save(rolUser);
      rol.setRol(rolRepository.getRol(rol.getRolId()).get().getRol());
    }
    userSave.setRol(user.getRol());
    return userSave;
  }

  public boolean delete(int userId){
    return getUser(userId).map(user -> {
      userRepository.delete(userId);
      return true;
    }).orElse(false);
  }
}
