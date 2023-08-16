package com.ravicla.jabank.persistence;

import com.ravicla.jabank.domain.MonthlySaving;
import com.ravicla.jabank.domain.repository.MonthlySavingRepository;
import com.ravicla.jabank.persistence.crud.AhorroMensualCrudRepository;
import com.ravicla.jabank.persistence.entity.AhorroMensual;
import com.ravicla.jabank.persistence.mapper.MonthlySavingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AhorroMensualRepository implements MonthlySavingRepository {
  @Autowired
  private AhorroMensualCrudRepository ahorroMensualCrudRepository;
  @Autowired
  private MonthlySavingMapper monthlySavingMapper;

  @Override
  public List<MonthlySaving> getAll() {
    List<AhorroMensual>ahorroMensuales = (List<AhorroMensual>) ahorroMensualCrudRepository.findAll();
    return monthlySavingMapper.toMonthlySavings(ahorroMensuales);
  }

  @Override
  public Optional<MonthlySaving> getMonthlySaving(int monthlySavingId) {
    return ahorroMensualCrudRepository.findById(monthlySavingId).map(ahorroMensual -> monthlySavingMapper.toMonthlySaving(ahorroMensual));
  }

  @Override
  public Optional<List<MonthlySaving>> getUserMonthlySavings(int userId) {
    return ahorroMensualCrudRepository.findByIdUsuario(userId).map(ahorroMensuales -> {
      List<MonthlySaving> listMonthlySaving = new ArrayList<>();
      for (AhorroMensual ahorroMensual : ahorroMensuales) {
        MonthlySaving monthlySaving = monthlySavingMapper.toMonthlySaving(ahorroMensual);
        listMonthlySaving.add(monthlySaving);
      }
      return listMonthlySaving;
    });
  }

  @Override
  public MonthlySaving save(MonthlySaving monthlySaving) {
    AhorroMensual ahorroMensual = monthlySavingMapper.toAhorroMensual(monthlySaving);
    return monthlySavingMapper.toMonthlySaving(ahorroMensualCrudRepository.save(ahorroMensual));
  }

  @Override
  public void delete(int ahorroMensualId) {
    ahorroMensualCrudRepository.deleteById(ahorroMensualId);
  }
}
