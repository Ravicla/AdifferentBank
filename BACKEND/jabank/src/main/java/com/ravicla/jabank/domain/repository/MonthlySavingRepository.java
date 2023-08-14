package com.ravicla.jabank.domain.repository;

import com.ravicla.jabank.domain.MonthlySaving;

import java.util.List;
import java.util.Optional;

public interface MonthlySavingRepository {
  List<MonthlySaving> getAll();
  Optional<MonthlySaving> getMonthlySaving(int monthlySavingId);
  MonthlySaving save(MonthlySaving monthlySaving);
  void delete(int monthlySavingId);
}
