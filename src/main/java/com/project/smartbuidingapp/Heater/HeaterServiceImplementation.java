package com.project.smartbuidingapp.Heater;

import com.project.smartbuidingapp.CustomType.HeaterStatus;
import org.springframework.beans.factory.annotation.Autowired;
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
    public HeaterDto addNewHeater(HeaterDto heaterDTO) {
        HeaterEntity heater = null;
       heaterRepository.save(new HeaterEntity(heaterDTO.getID(),heaterDTO.getName(),heaterDTO.getHeaterStatus(),heaterDTO.getRoomID(),heaterDTO.getCurrentTemperature(),heaterDTO.getTargetTemperature()));

        return heaterDTO;
    }
}
