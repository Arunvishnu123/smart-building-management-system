package com.project.smartbuidingapp.Heater;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeaterRepository extends JpaRepository<HeaterEntity, Long> {
      List<HeaterEntity> findByRoomID(Long roomID);
}
