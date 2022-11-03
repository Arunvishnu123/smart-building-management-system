package com.project.smartbuidingapp.Building;

import com.project.smartbuidingapp.Room.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BuildingRepository extends JpaRepository<BuildingEntity,Long> {
    BuildingEntity findByBuildingName(Long buildingName);
}
