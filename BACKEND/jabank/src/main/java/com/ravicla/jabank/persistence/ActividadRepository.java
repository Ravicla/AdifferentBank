package com.ravicla.jabank.persistence;

import com.ravicla.jabank.domain.Activity;
import com.ravicla.jabank.domain.repository.ActivityRepository;
import com.ravicla.jabank.persistence.crud.ActividadCrudRepository;
import com.ravicla.jabank.persistence.entity.Actividad;
import com.ravicla.jabank.persistence.mapper.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ActividadRepository implements ActivityRepository {
  @Autowired
  private ActividadCrudRepository actividadCrudRepository;
  @Autowired
  private ActivityMapper activityMapper;


  @Override
  public List<Activity> getAll() {
    List<Actividad> actividades = (List<Actividad>) actividadCrudRepository.findAll();
    return activityMapper.toActivities(actividades);
  }

  @Override
  public Optional<Activity> getActivity(int activityId) {
    return actividadCrudRepository.findById(activityId).map(actividad -> activityMapper.toActivity(actividad));
  }

  @Override
  public Optional<List<Activity>> getUserActivities(int userId) {
    return actividadCrudRepository.findByIdUsuario(userId).map(actividades -> {
      List<Activity> listActivities = new ArrayList<>();
      for (Actividad actividad : actividades) {
        Activity activity = activityMapper.toActivity(actividad);
        listActivities.add(activity);
      }
      return listActivities;
    });
  }


  @Override
  public Activity save(Activity activity) {
    Actividad actividad = activityMapper.toActividad(activity);
    return activityMapper.toActivity(actividadCrudRepository.save(actividad));
  }

  @Override
  public void delete(int actividadId) {
    actividadCrudRepository.deleteById(actividadId);
  }
}
