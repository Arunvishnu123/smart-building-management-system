package com.project.smartbuidingapp.Building;


import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping(path = "api/v1")
public class BuildingController {

    @Autowired
    private BuildingService buildingService ;

    @PostMapping("/building")
    public BuildingDTO addNewBuilding(@RequestBody BuildingDTO dto){
        System.out.println(dto);
        buildingService.addNewBuilding(dto);
        return dto;
    }


    @DeleteMapping("/buildings/{buildingID}")
    public void deleteBuilding(@PathVariable Long buildingID){
        buildingService.deleteBuildingByID(buildingID);
    }

    @GetMapping("/buildings")
    public List<BuildingDTO> getAllBuildings(){
        return buildingService.getAllBuildings();
    }
    @GetMapping("/buildings/{buildingID}")
    public BuildingDTO getBuildingByID(@PathVariable("buildingID") Long buildingID){
        return buildingService.getBuildingByID(buildingID);
    }

}
