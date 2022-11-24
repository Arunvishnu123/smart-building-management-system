package com.project.smartbuidingapp.Building;


import com.project.smartbuidingapp.ResponseClass.BuildingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@RequestMapping(path = "api/v1")
public class BuildingController {

@Autowired
    private BuildingService buildingService ;

    @PostMapping("/building/new")
    public ResponseEntity<BuildingResponse>  addNewBuilding(@RequestBody BuildingPost dto){
        System.out.println("Building data " + dto);
        return buildingService.addNewBuilding(dto);
    }


    @DeleteMapping("/buildings/{ID}")
    public void deleteBuilding(@PathVariable("ID") Long buildingID){
        buildingService.deleteBuildingByID(buildingID);
    }

    @GetMapping("/buildings")
    public List<BuildingDto> getAllBuildings(){
        return buildingService.getAllBuildings();
    }

    @GetMapping("/buildings/{ID}")
    public BuildingDto getBuildingByID(@PathVariable("ID") Long buildingID){
        return buildingService.getBuildingByID(buildingID);
    }
    @GetMapping("/building/{buildingName}")
    public BuildingEntity getBuildingByName(@PathVariable("buildingName") String buildingName){
        return buildingService.getBuildingByName(buildingName);
    }



}
