package com.project.smartbuidingapp.Room;

import com.project.smartbuidingapp.Heater.HeaterDTO;
import com.project.smartbuidingapp.Heater.HeaterEntity;
import com.project.smartbuidingapp.Window.WindowDTO;
import com.project.smartbuidingapp.Window.WindowEntity;

import java.util.List;

public interface RoomService {


    List<RoomDTO> getAllRooms();
    RoomDTO getRoomById(Long Id);
    void deleteRoomByID(Long Id);
    RoomDTO addNewRoom(RoomDTO roomDTO);

    List<HeaterEntity>  changeAllHeaterStatus(Long roomID);
    List<WindowEntity> changeAllWindowStatus(Long roomID);


}
