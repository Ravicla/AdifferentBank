package com.ravicla.jabank.persistence.mapper;

import com.ravicla.jabank.domain.User;
import com.ravicla.jabank.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
@Mapper(componentModel = "spring")

public interface UserMapper {
  @Mappings({
    @Mapping(source = "idUsuario", target = "userId"),
    @Mapping(source = "cedula", target = "identificationNumber"),
    @Mapping(source = "nombre", target = "firstName"),
    @Mapping(source = "apellido", target = "lastName"),
    @Mapping(source = "fechaNacimiento", target = "birthdate"),
    @Mapping(source = "correo", target = "emailAddress"),
    @Mapping(source = "telefono", target = "phoneNumber"),
  })
  User toUser(Usuario usuario);
  List<User> toUsers(List<Usuario>usuarios);
  @InheritInverseConfiguration
  Usuario toUsuario(User user);
}
