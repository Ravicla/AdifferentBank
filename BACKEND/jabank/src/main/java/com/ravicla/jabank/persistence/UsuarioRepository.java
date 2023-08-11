package com.ravicla.jabank.persistence;

import com.ravicla.jabank.domain.User;
import com.ravicla.jabank.domain.repository.UserRepository;
import com.ravicla.jabank.persistence.crud.UsuarioCrudRepository;
import com.ravicla.jabank.persistence.entity.Usuario;
import com.ravicla.jabank.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class UsuarioRepository implements UserRepository {
  @Autowired
  private UsuarioCrudRepository usuarioCrudRepository;
  @Autowired
  private UserMapper userMapper;

  @Override
  public List<User> getAll() {
    List<Usuario>usuarios = (List<Usuario>) usuarioCrudRepository.findAll();
    return userMapper.toUsers(usuarios);
  }

  @Override
  public Optional<User> getUser(int userId) {
    return usuarioCrudRepository.findById(userId).map(usuario -> userMapper.toUser(usuario));
  }

  @Override
  public Optional<User> getLogin(String correo, String cedula) {
    return usuarioCrudRepository.findByCorreoAndCedula(correo, cedula).map(usuario -> userMapper.toUser(usuario));
  }

  @Override
  public User save(User user) {
    Usuario usuario = userMapper.toUsuario(user);
    return userMapper.toUser(usuarioCrudRepository.save(usuario));
  }

  @Override
  public void delete(int usuarioId) {
    usuarioCrudRepository.deleteById(usuarioId);
  }
}
