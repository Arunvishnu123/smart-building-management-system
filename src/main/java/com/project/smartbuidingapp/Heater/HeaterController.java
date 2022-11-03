package com.project.smartbuidingapp.Heater;

import com.project.smartbuidingapp.Building.BuildingDTO;
import com.project.smartbuidingapp.Building.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController

@RequestMapping(path = "api/v1")
public class HeaterController {
    @Autowired
    private HeaterService heaterService ;

    @PostMapping("/heater/new")
    public ResponseEntity<HeaterDTO> addNewHeater(@RequestBody HeaterDTO dto){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/heater/new").toUriString());
        return ResponseEntity.created(uri).body(heaterService.addNewHeater(dto));
    }
    @GetMapping("/heaters")
    public List<HeaterDTO> getAllHeaters(){
        return heaterService.getAllHeaters();
    }
    @GetMapping("/heaters/{roomID}")
    public List<HeaterDTO> getAllHeatersInSameRoom(@PathVariable("roomID") Long roomID){
        return heaterService.getHeatersFromRoomID(roomID);
    }

    @GetMapping("/heater/{heaterID}")
    public HeaterDTO getHeaterByID(@PathVariable("heaterID") Long heaterID){
        return heaterService.getHeatersById(heaterID);
    }


    @DeleteMapping("/heaters/{heaterID}")
    public void deleteHeaterById(@PathVariable Long heaterID){
        heaterService.deleteHeaterByID(heaterID);
    }

    @PutMapping("/heater/{heaterID}/status")
    public HeaterEntity changeHeaterStatus(@PathVariable("heaterID") Long heaterID){

        return heaterService.changeHeaterStatusById(heaterID);
    }


}
