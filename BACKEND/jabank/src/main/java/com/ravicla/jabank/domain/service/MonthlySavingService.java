package com.ravicla.jabank.domain.service;

import com.ravicla.jabank.domain.MonthlySaving;
import com.ravicla.jabank.domain.repository.MonthlySavingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonthlySavingService {
  @Autowired
  private MonthlySavingRepository monthlySavingRepository;

  public List<MonthlySaving> getAll(){
    List<MonthlySaving> monthlySavingGetAll = monthlySavingRepository.getAll();
    return (List<MonthlySaving>) monthlySavingGetAll;
  }

  public Optional<MonthlySaving> getMonthlySaving(int monthlySavingId) {
    Optional<MonthlySaving> monthlySaving = monthlySavingRepository.getMonthlySaving(monthlySavingId);
    return (Optional<MonthlySaving>) monthlySaving;
  }

  public MonthlySaving save (MonthlySaving monthlySaving) {
    MonthlySaving monthlySavingSave = monthlySavingRepository.save(monthlySaving);
    return monthlySavingSave;
  }

  public boolean delete(int monthlySavingId) {
    return getMonthlySaving(monthlySavingId).map(monthlySaving -> {
      monthlySavingRepository.delete(monthlySavingId);
      return  true;
    }).orElse(false);
  }

}
