package com.ravicla.jabank.persistence.mapper;

import com.ravicla.jabank.domain.TypeActivity;
import com.ravicla.jabank.persistence.entity.TipoActividad;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TypeActivityMapper {
  @Mappings({
    @Mapping(source = "idTipoActividad", target = "typeActivityId"),
    @Mapping(source = "actividad", target = "activity"),

  })
  TypeActivity toTypeActivity(TipoActividad tipoActividad);
  List<TypeActivity> toTypeActivities(List<TipoActividad>tipoActividades);
  @InheritInverseConfiguration
  TipoActividad toTipoActividad(TypeActivity typeActivity);
}
