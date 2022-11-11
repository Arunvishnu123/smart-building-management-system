package com.project.smartbuidingapp.Room;

import com.project.smartbuidingapp.ResponseClass.RoomResponse;
import com.project.smartbuidingapp.Heater.HeaterEntity;
import com.project.smartbuidingapp.Window.WindowEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoomService {


    List<RoomDto> getAllRooms();
    RoomDto getRoomById(Long Id);
    void deleteRoomByID(Long Id);
    ResponseEntity<RoomResponse> addNewRoom(RoomPost roomDTO);

    List<HeaterEntity>  changeAllHeaterStatus(Long roomID);
    List<WindowEntity> changeAllWindowStatus(Long roomID);


}
