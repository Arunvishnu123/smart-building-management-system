package com.project.smartbuidingapp.Heater;

import com.project.smartbuidingapp.ResponseClass.HeaterResponse;
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

    @PostMapping("/newheater")
    public ResponseEntity<HeaterResponse>addNewHeater(@RequestBody HeaterDto dto){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/heater/new").toUriString());
        return heaterService.addNewHeater(dto);
    }
    @GetMapping("/heaters")
    public List<HeaterDto> getAllHeaters(){
        return heaterService.getAllHeaters();
    }
    @GetMapping("/heaters/{roomID}")
    public List<HeaterDto> getAllHeatersInSameRoom(@PathVariable("roomID") Long roomID){
        return heaterService.getHeatersFromRoomID(roomID);
    }

    @GetMapping("/heater/{heaterID}")
    public HeaterDto getHeaterByID(@PathVariable("heaterID") Long heaterID){
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
  /*  @PostMapping("/updateHeater")
    public ResponseEntity<HeaterResponse> updateHeater(@RequestBody HeaterDto dto){
        return heaterService.updateHeater(dto);
    }

   */



}
