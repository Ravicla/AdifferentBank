package com.ravicla.jabank.persistence.mapper;

import com.ravicla.jabank.domain.MonthlySaving;
import com.ravicla.jabank.persistence.entity.AhorroMensual;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
@Mapper(componentModel = "spring")
public interface MonthlySavingMapper {
  @Mappings({
    @Mapping(source = "idAhorroMensual", target = "monthlySavingId"),
    @Mapping(source = "fecha", target = "date"),
    @Mapping(source = "valor", target = "cost"),
    @Mapping(source = "idUsuario", target = "userId")
  })
  MonthlySaving toMonthlySaving(AhorroMensual ahorroMensual);
  List<MonthlySaving>toMonthlySavings(List<AhorroMensual>ahorroMensuales);
  @InheritInverseConfiguration
  AhorroMensual toAhorroMensual(MonthlySaving monthlySaving);
}
