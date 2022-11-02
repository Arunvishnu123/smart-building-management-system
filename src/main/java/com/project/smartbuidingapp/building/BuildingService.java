package com.project.smartbuidingapp.Building;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BuildingService {


    private final BuildingRepository buildingRepository;

    public List<BuildingDTO> getAllBuildings() {
        return buildingRepository.findAll().stream().map(BuildingDTO::new).collect(Collectors.toList());
    }

    public BuildingDTO getBuildingByID(Long id) {
        return buildingRepository.findById(id).map(BuildingDTO::new).orElse(null);
    }

    public void deleteBuildingByID(Long id) {
        buildingRepository.deleteById(id);
    }

    public BuildingDTO addNewBuilding(BuildingDTO newDTO) {
        BuildingEntity buildingEntity = null;
        buildingRepository.save(new BuildingEntity(newDTO.getID(), newDTO.getBuildingID(), newDTO.getBuildingName(), newDTO.getBuildingAddress(), newDTO.getBuildingOwner(), newDTO.getStoreyNumber(), newDTO.getBuildingType(), newDTO.getBuildingSize(), newDTO.getBuildingAge()));
        return newDTO;
    }
}