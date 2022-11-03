package com.project.smartbuidingapp.Room;

import com.project.smartbuidingapp.CustomType.HeaterStatus;
import com.project.smartbuidingapp.CustomType.WindowStatus;
import com.project.smartbuidingapp.Heater.HeaterEntity;
import com.project.smartbuidingapp.Heater.HeaterRepository;
import com.project.smartbuidingapp.Window.WindowEntity;
import com.project.smartbuidingapp.Window.WindowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class RoomServiceImplementation implements RoomService{

    @Autowired
    private final RoomRepository roomRepository;

    @Autowired
    private final WindowRepository windowRepository;
    @Autowired
    private final HeaterRepository heaterRepository;


    @Override
    public List<RoomDto> getAllRooms() {

        return  roomRepository.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @Override
    public RoomDto getRoomById(Long Id) {
        return roomRepository.findById(Id).map(RoomDto::new).orElse(null);
    }

    @Override
    public void deleteRoomByID(Long Id) {
        roomRepository.deleteById(Id);
    }

    @Override
    public RoomDto addNewRoom(RoomDto roomDTO) {
       RoomEntity room = null;
        roomRepository.save(new RoomEntity(roomDTO.getID(),roomDTO.getRoomName(),roomDTO.getRoomID(),roomDTO.getRoomTemperature(),roomDTO.getBuildingID()));

        return roomDTO;
    }

    @Override
    public  List<HeaterEntity>  changeAllHeaterStatus(Long roomID) {
    List<HeaterEntity>  heaters = heaterRepository.findByRoomID(roomID);
    for(int  i = 0 ; i<heaters.toArray().length;i++ ){

        heaters.get(i).setHeaterStatus (heaters.get(i).getHeaterStatus() == HeaterStatus.ON ? HeaterStatus.OFF : HeaterStatus.ON);

    }

        return heaters;
    }

    @Override
    public List<WindowEntity> changeAllWindowStatus(Long roomID) {
        List<WindowEntity>  windows = windowRepository.findByRoomID(roomID);
        for(int  i = 0 ; i<windows.toArray().length;i++ ){

        windows.get(i).setWindowStatus (windows.get(i).getWindowStatus() == WindowStatus.CLOSE ? WindowStatus.OPEN : WindowStatus.CLOSE);

        }

        return windows;
    }
}
