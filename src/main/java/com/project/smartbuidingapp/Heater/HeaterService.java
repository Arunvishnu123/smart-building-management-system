package com.project.smartbuidingapp.Heater;

import com.project.smartbuidingapp.Building.BuildingDTO;

import java.util.List;

public interface HeaterService {

    List<HeaterDTO> getAllHeaters();
    HeaterDTO getHeatersById(Long Id);
    void deleteHeaterByID(Long Id);
    HeaterEntity changeHeaterStatusById(Long ID);

    List<HeaterDTO> getHeatersFromRoomID(Long roomID);

    HeaterDTO addNewHeater(HeaterDTO heaterDTO);



}
