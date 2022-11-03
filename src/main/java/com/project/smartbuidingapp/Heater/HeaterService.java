package com.project.smartbuidingapp.Heater;

import com.project.smartbuidingapp.Building.BuildingDto;

import java.util.List;

public interface HeaterService {

    List<HeaterDto> getAllHeaters();
    HeaterDto getHeatersById(Long Id);
    void deleteHeaterByID(Long Id);
    HeaterEntity changeHeaterStatusById(Long ID);

    List<HeaterDto> getHeatersFromRoomID(Long roomID);

    HeaterDto addNewHeater(HeaterDto heaterDTO);



}
