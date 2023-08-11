package com.ravicla.jabank.domain.service;

import com.ravicla.jabank.domain.User;
import com.ravicla.jabank.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class UserService {
  @Autowired
  private UserRepository userRepository;

  public List<User> getAll(){
    List<User> userGetAll = userRepository.getAll();
    return (List<User>) userGetAll;
  }

  public Optional<User> getUser(int userId){
    Optional<User> userIdOut = userRepository.getUser(userId);
    return (Optional<User>) userIdOut;
  }


  public Optional<User> getLogin(String correo, String cedula){
    Optional<User> userIdOut = userRepository.getLogin(correo, cedula);
    return (Optional<User>) userIdOut;
  }

  public User save(User user){
    User userSaveOut = userRepository.save(user);
    return userSaveOut;
  }

  public boolean delete(int userId){
    return getUser(userId).map(user -> {
      userRepository.delete(userId);
      return true;
    }).orElse(false);
  }
}
