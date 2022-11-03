package com.project.smartbuidingapp.Building;


import com.project.smartbuidingapp.User.Model.Role;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController

@RequestMapping(path = "api/v1")
public class BuildingController {

@Autowired
    private BuildingService buildingService ;

    @PostMapping("/building")
    public ResponseEntity<BuildingEntity> addNewBuilding(@RequestBody BuildingDTO dto){
        System.out.println("Building data " + dto);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/building").toUriString());

        return ResponseEntity.created(uri).body(buildingService.addNewBuilding(dto));
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
