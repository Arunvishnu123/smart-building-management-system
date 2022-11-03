package com.project.smartbuidingapp.Room;

import com.project.smartbuidingapp.Heater.HeaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Long> {

    //list all rooms in the same building
    List<RoomEntity> findByBuildingID(Long buildingID);
}
