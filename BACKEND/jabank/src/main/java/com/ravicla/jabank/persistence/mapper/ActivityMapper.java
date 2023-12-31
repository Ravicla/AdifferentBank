package com.ravicla.jabank.persistence.mapper;

import com.ravicla.jabank.domain.Activity;
import com.ravicla.jabank.persistence.entity.Actividad;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActivityMapper {

  @Mappings({
    @Mapping(source = "idActividad", target = "activityId"),
    @Mapping(source = "valor", target = "cost"),
    @Mapping(source = "descripcion", target = "description"),
    @Mapping(source = "fecha", target = "date"),
    @Mapping(source = "idUsuario", target = "userId"),
    @Mapping(source = "idTipoActividad", target = "typeActivityId")

  })
  Activity toActivity(Actividad actividad);
  List<Activity> toActivities(List<Actividad>actividades);
  @InheritInverseConfiguration
  Actividad toActividad(Activity activity);
}
