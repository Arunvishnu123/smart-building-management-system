package com.project.smartbuidingapp.Building;

import com.project.smartbuidingapp.ResponseClass.BuildingResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BuildingService {

    List<BuildingDto> getAllBuildings();
    BuildingDto getBuildingByID(Long id);
    BuildingEntity getBuildingByName(String buildingName);
    void deleteBuildingByID(Long id);
    ResponseEntity<BuildingResponse> addNewBuilding(BuildingPost newDTO);
}
