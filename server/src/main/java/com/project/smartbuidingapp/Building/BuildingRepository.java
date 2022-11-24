package com.project.smartbuidingapp.Building;

import com.project.smartbuidingapp.Room.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BuildingRepository extends JpaRepository<BuildingEntity,Long> {


    BuildingEntity findByBuildingName(String buildingName);
    BuildingEntity findByBuildingID(Long buildingID);
}
