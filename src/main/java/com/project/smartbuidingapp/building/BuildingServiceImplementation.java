package com.project.smartbuidingapp.Building;

import com.project.smartbuidingapp.ResponseClass.BuildingResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class BuildingServiceImplementation implements BuildingService {
    @Autowired
    private final BuildingRepository buildingRepository;
    @Override
    public List<BuildingDto> getAllBuildings() {
        return buildingRepository.findAll().stream().map(BuildingDto::new).collect(Collectors.toList());
    }

    @Override
    public BuildingDto getBuildingByID(Long id) {
        return buildingRepository.findById(id).map(BuildingDto::new).orElse(null);
    }

    @Override
    public BuildingEntity getBuildingByName(String buildingName) {
        return buildingRepository.findByBuildingName(buildingName);
    }

    // @Override
   // public BuildingDto getBuildingByName(String buildingName) {
   //     return buildingRepository.findByBuildingName(buildingName).map(BuildingDto::new).orElse(null);
   // }

    @Override
    public void deleteBuildingByID(Long id) {
        buildingRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<BuildingResponse> addNewBuilding(BuildingPost newDTO) {
        if( buildingRepository.findByBuildingID(newDTO.getBuildingID()) == null){
            BuildingEntity buildingEntity = null;
            buildingRepository.save(new BuildingEntity(newDTO.getID(), newDTO.getBuildingID(), newDTO.getBuildingName(), newDTO.getBuildingAddress(), newDTO.getBuildingOwner(), newDTO.getStoreyNumber(), newDTO.getBuildingType(), newDTO.getBuildingSize(), newDTO.getBuildingAge()));
            BuildingResponse buildingResponse = new BuildingResponse() ;
            buildingResponse.buildingPost = newDTO ;
            buildingResponse.response = "Data Successfully added" ;
            return new ResponseEntity<>(buildingResponse, HttpStatus.CREATED);
        } else{
            BuildingResponse buildingResponse = new BuildingResponse() ;
            buildingResponse.buildingPost = newDTO ;
            buildingResponse.response = "Building ID already exist in the database" ;
             return new ResponseEntity<>(buildingResponse, HttpStatus.CONFLICT);
        }
    }
}
