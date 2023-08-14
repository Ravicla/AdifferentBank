package com.ravicla.jabank.persistence;

import com.ravicla.jabank.domain.MonthlySaving;
import com.ravicla.jabank.domain.repository.MonthlySavingRepository;
import com.ravicla.jabank.persistence.crud.AhorroMensualCrudRepository;
import com.ravicla.jabank.persistence.entity.AhorroMensual;
import com.ravicla.jabank.persistence.mapper.MonthlySavingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    List<AhorroMensual>ahorroMensuals = (List<AhorroMensual>) ahorroMensualCrudRepository.findAll();
    return monthlySavingMapper.toMonthlySavings(ahorroMensuals);
  }

  @Override
  public Optional<MonthlySaving> getMonthlySaving(int monthlySavingId) {
    return ahorroMensualCrudRepository.findById(monthlySavingId).map(ahorroMensual -> monthlySavingMapper.toMonthlySaving(ahorroMensual));
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
