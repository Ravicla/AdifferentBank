package com.ravicla.jabank.persistence.mapper;

import com.ravicla.jabank.domain.Rol;
import com.ravicla.jabank.persistence.entity.Cargo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RolMapper {
  @Mappings({
    @Mapping(source = "idCargo", target = "rolId"),
    @Mapping(source = "cargo", target = "description"),

  })
  Rol toRol(Cargo cargo);
  List<Rol> toRoles(List<Cargo>cargos);
  @InheritInverseConfiguration
  Cargo toCargo(Rol rol);
}
