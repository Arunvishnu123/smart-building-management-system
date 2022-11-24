package com.project.smartbuidingapp.Heater;

import com.project.smartbuidingapp.ResponseClass.HeaterResponse;
import com.project.smartbuidingapp.CustomType.HeaterStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional

public class HeaterServiceImplementation implements HeaterService{
@Autowired
    private final HeaterRepository heaterRepository;

    public HeaterServiceImplementation(HeaterRepository heaterRepository) {
        this.heaterRepository = heaterRepository;
    }

    @Override
    public List<HeaterDto> getAllHeaters() {
        return  heaterRepository.findAll().stream().map(HeaterDto::new).collect(Collectors.toList());
    }

    @Override
    public HeaterDto getHeatersById(Long Id) {
        return  heaterRepository.findById(Id).map(HeaterDto::new).orElse(null);
    }

    @Override
    public void deleteHeaterByID(Long Id) {
      heaterRepository.deleteById(Id);

    }

    @Override
    public HeaterEntity changeHeaterStatusById(Long ID) {

        HeaterEntity heater = heaterRepository.findById(ID).orElseThrow(IllegalArgumentException::new);
        heater.setHeaterStatus (heater.getHeaterStatus() == HeaterStatus.ON ? HeaterStatus.OFF : HeaterStatus.ON);

        return heater;
    }



      @Override
    public List<HeaterDto> getHeatersFromRoomID(Long roomID) {
        return heaterRepository.findByRoomID(roomID).stream().map(HeaterDto::new).collect(Collectors.toList());
   }

    @Override
    public ResponseEntity<HeaterResponse> addNewHeater(HeaterDto heaterDTO) {

        if(heaterRepository.findByRoomID(heaterDTO.getRoomID()) != null){
            HeaterEntity heater = null;
            heaterRepository.save(new HeaterEntity(heaterDTO.getID(),heaterDTO.getName(),heaterDTO.getHeaterStatus(),heaterDTO.getRoomID(),heaterDTO.getCurrentTemperature(),heaterDTO.getTargetTemperature()));
            HeaterResponse heaterResponse = new HeaterResponse();
            heaterResponse.heaterPost = heaterDTO;
            heaterResponse.response ="new heater is created" ;


            return new ResponseEntity<>(heaterResponse, HttpStatus.CREATED);
        }else{
            HeaterResponse heaterResponse = new HeaterResponse();
            heaterResponse.heaterPost = heaterDTO;
            heaterResponse.response ="room id is not found" ;


            return new ResponseEntity<>(heaterResponse, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<HeaterResponse> updateHeater(HeaterDto heaterDTO) {
        if(heaterRepository.findById(heaterDTO.getID()) != null){
            HeaterEntity heater = null;
            heaterRepository.save(new HeaterEntity(heaterDTO.getID(),heaterDTO.getName(),heaterDTO.getHeaterStatus(),heaterDTO.getRoomID(),heaterDTO.getCurrentTemperature(),heaterDTO.getTargetTemperature()));
            HeaterResponse heaterResponse = new HeaterResponse();
            heaterResponse.heaterPost = heaterDTO;
            heaterResponse.response ="heater updated succesfully" ;
            return new ResponseEntity<>(heaterResponse, HttpStatus.CREATED);

        }else{
            HeaterResponse heaterResponse = new HeaterResponse();
            heaterResponse.heaterPost = heaterDTO;
            heaterResponse.response ="heater is not found in the database" ;


            return new ResponseEntity<>(heaterResponse, HttpStatus.NOT_FOUND);
        }
    }
}
