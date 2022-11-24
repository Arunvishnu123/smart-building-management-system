package com.project.smartbuidingapp.Heater;

import com.project.smartbuidingapp.ResponseClass.HeaterResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HeaterService {

    List<HeaterDto> getAllHeaters();
    HeaterDto getHeatersById(Long Id);
    void deleteHeaterByID(Long Id);
    HeaterEntity changeHeaterStatusById(Long ID);

    List<HeaterDto> getHeatersFromRoomID(Long roomID);

    ResponseEntity<HeaterResponse> addNewHeater(HeaterDto heaterDTO);

    ResponseEntity<HeaterResponse> updateHeater(HeaterDto heaterDTO);



}
