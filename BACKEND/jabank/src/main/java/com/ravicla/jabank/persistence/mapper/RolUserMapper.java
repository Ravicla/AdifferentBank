package com.ravicla.jabank.persistence.mapper;

import com.ravicla.jabank.domain.Rol;
import com.ravicla.jabank.domain.RolUser;
import com.ravicla.jabank.domain.User;
import com.ravicla.jabank.persistence.entity.Cargo;
import com.ravicla.jabank.persistence.entity.CargoUsuario;
import com.ravicla.jabank.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RolUserMapper {
  @Mappings({
    @Mapping(source = "idCargoUsuario", target = "rolUserId"),
    @Mapping(source = "idCargo", target = "rolId"),
    @Mapping(source = "idUsuario", target = "userId"),

  })
  RolUser toRolUser(CargoUsuario cargoUsuario);
  List<RolUser> toRolUsers(List<CargoUsuario>cargoUsuarios);
  @InheritInverseConfiguration
  CargoUsuario toCargoUsuario(RolUser rolUser);
}
