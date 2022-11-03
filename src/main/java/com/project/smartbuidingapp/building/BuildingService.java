package com.project.smartbuidingapp.Building;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class BuildingService {

@Autowired
    private final BuildingRepository buildingRepository;

    public List<BuildingDto> getAllBuildings() {
        return buildingRepository.findAll().stream().map(BuildingDto::new).collect(Collectors.toList());
    }

    public BuildingDto getBuildingByID(Long id) {
        return buildingRepository.findById(id).map(BuildingDto::new).orElse(null);
    }

    public void deleteBuildingByID(Long id) {
        buildingRepository.deleteById(id);
    }

    public BuildingDto addNewBuilding(BuildingDto newDTO) {

        BuildingEntity buildingEntity = null;
        buildingRepository.save(new BuildingEntity(newDTO.getID(), newDTO.getBuildingID(), newDTO.getBuildingName(), newDTO.getBuildingAddress(), newDTO.getBuildingOwner(), newDTO.getStoreyNumber(), newDTO.getBuildingType(), newDTO.getBuildingSize(), newDTO.getBuildingAge()));

        return newDTO;
    }
}