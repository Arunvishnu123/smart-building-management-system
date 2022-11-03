package com.project.smartbuidingapp.Room;

import com.project.smartbuidingapp.Heater.HeaterEntity;
import com.project.smartbuidingapp.Window.WindowEntity;

import java.util.List;

public interface RoomService {


    List<RoomDto> getAllRooms();
    RoomDto getRoomById(Long Id);
    void deleteRoomByID(Long Id);
    RoomDto addNewRoom(RoomDto roomDTO);

    List<HeaterEntity>  changeAllHeaterStatus(Long roomID);
    List<WindowEntity> changeAllWindowStatus(Long roomID);


}
