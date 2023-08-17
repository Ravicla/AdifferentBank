package com.ravicla.jabank.domain.service;

import com.ravicla.jabank.domain.*;
import com.ravicla.jabank.domain.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.Authenticator;
import java.util.*;

@Service

public class UserService {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private RolRepository rolRepository;
  @Autowired
  private RolUserRepository rolUserRepository;
  @Autowired
  private ActivityRepository activityRepository;
  @Autowired
  private MonthlySavingRepository monthlySavingRepository;
   @Autowired
   private TypeActivityRepository typeActivityRepository;


  public List<User> getAll(){
    List<User> userGetAll = userRepository.getAll();
    for (User users : userGetAll) {
      List<RolUser> rolUsers = rolUserRepository.getByIdUsuario(users.getUserId());
      List<Rol> roles = new ArrayList<>();
      for (RolUser rolUser : rolUsers) {
        Rol rol = new Rol();
        rol = rolRepository.getRol(rolUser.getRolId()).get();
        roles.add(rol);
      }
      users.setRol(roles);
    }
    return (List<User>) userGetAll;
  }

  public Optional<User> getUser(int userId){
    Optional<User> user = userRepository.getUser(userId);
    List<RolUser> rolUsers = rolUserRepository.getByIdUsuario(user.get().getUserId());

    List<Rol> roles = new ArrayList<>();
    for (RolUser rolUser : rolUsers) {
      Rol rol = new Rol();
      rol = rolRepository.getRol(rolUser.getRolId()).get();
      roles.add(rol);
      rol.setDescription(rolRepository.getRol(rol.getRolId()).get().getDescription());
    }
    user.get().setRol(roles);
    return (Optional<User>) user;
  }


  public Optional<User> getLogin(String correo, String cedula){
    Optional<User> user = userRepository.getLogin(correo, cedula);
    List<RolUser> rolUsers = rolUserRepository.getByIdUsuario(user.get().getUserId());
    List<Rol> roles = new ArrayList<>();
    for (RolUser rolUser : rolUsers) {
      Rol rol = new Rol();
      rol = rolRepository.getRol(rolUser.getRolId()).get();
      roles.add(rol);
    }
    user.get().setRol(roles);
    return (Optional<User>) user;
  }

  public User save(User user){
    User userSave = userRepository.save(user);
    for (Rol rol: user.getRol()) {
      RolUser rolUser = new RolUser();
      rolUser.setRolId(rol.getRolId());
      rolUser.setUserId(userSave.getUserId());
      rolUserRepository.save(rolUser);
      rol.setDescription(rolRepository.getRol(rol.getRolId()).get().getDescription());
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

  public Optional<UserActivity> getUserActivities(int userId){
    // Crear una instancia de la clase User
    UserActivity userActivities = new UserActivity();
    Optional<UserActivity> optionalUser = Optional.of(userActivities);
    Optional<User> user = userRepository.getUser(userId);
    if(user.isPresent())
    {
      optionalUser.get().setUserId(user.get().getUserId());
      optionalUser.get().setFirstName(user.get().getFirstName());
      optionalUser.get().setLastName(user.get().getLastName());
      //completar
      List<Activity> activityList = activityRepository.getUserActivities(user.get().getUserId()).get();
      optionalUser.get().setActivityList(activityList);

      for (Activity activity : activityList) {
        TypeActivity typeActivity = new TypeActivity();
        typeActivity = typeActivityRepository.getTypeActivity(activity.getTypeActivityId()).get();
        activity.setTypeActivity(typeActivity);
      }


    }


    return optionalUser;
  }

  public Optional<UserMonthlySaving> getUserMonthlySaving(int userId){
    // Crear una instancia de la clase User
    UserMonthlySaving userMonthlySaving  = new UserMonthlySaving();
    Optional<UserMonthlySaving> optionalUser = Optional.of(userMonthlySaving);
    Optional<User> user = userRepository.getUser(userId);
    if(user.isPresent())
    {
      optionalUser.get().setUserId(user.get().getUserId());
      optionalUser.get().setFirstName(user.get().getFirstName());
      optionalUser.get().setLastName(user.get().getLastName());
      //completar
      List<MonthlySaving> monthlySavingList = monthlySavingRepository.getUserMonthlySavings(user.get().getUserId()).get();
      optionalUser.get().setMonthlySavingList (monthlySavingList);
    }

    return optionalUser;
  }
}
