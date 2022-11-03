package com.project.smartbuidingapp.Room;

import com.project.smartbuidingapp.Heater.HeaterDTO;
import com.project.smartbuidingapp.Heater.HeaterEntity;
import com.project.smartbuidingapp.Heater.HeaterService;
import com.project.smartbuidingapp.Window.WindowEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController

@RequestMapping(path = "api/v1")
public class RoomController {
    @Autowired
    private RoomService roomService ;

    @PostMapping("/room/new")
    public ResponseEntity<RoomDTO> addNewRoom(@RequestBody RoomDTO dto){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/room/new").toUriString());
        return ResponseEntity.created(uri).body(roomService.addNewRoom(dto));
    }
    @GetMapping("/rooms")
    public List<RoomDTO> getAllRooms(){
        return roomService.getAllRooms();
    }
    @GetMapping("/room/{roomID}")
    public RoomDTO getRoomById(@PathVariable("roomID") Long roomID){
        return roomService.getRoomById(roomID);
    }



    @DeleteMapping("/room/{roomID}")
    public void deleteRoomById(@PathVariable Long roomID){
        roomService.deleteRoomByID(roomID);
    }

    @PutMapping("/room/{roomID}/switch/heaters")
    public List<HeaterEntity>  changeAllHeaterStatusByRoomId(@PathVariable("roomID") Long roomID){

        return roomService.changeAllHeaterStatus(roomID);
    }

    @PutMapping("/room/{roomID}/switch/windows")
    public List<WindowEntity> changeAllWindowStatusByRoomId(@PathVariable("roomID") Long roomID){

        return roomService.changeAllWindowStatus(roomID);
    }

}
