package com.project.smartbuidingapp.Heater;

import com.project.smartbuidingapp.Building.BuildingDTO;
import com.project.smartbuidingapp.Building.BuildingEntity;
import com.project.smartbuidingapp.CustomType.HeaterStatus;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class HeaterServiceImplementation implements HeaterService{
@Autowired
    private final HeaterRepository heaterRepository;

    @Override
    public List<HeaterDTO> getAllHeaters() {
        return  heaterRepository.findAll().stream().map(HeaterDTO::new).collect(Collectors.toList());
    }

    @Override
    public HeaterDTO getHeatersById(Long Id) {
        return  heaterRepository.findById(Id).map(HeaterDTO::new).orElse(null);
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
    public List<HeaterDTO> getHeatersFromRoomID(Long roomID) {
        return heaterRepository.findByRoomID(roomID).stream().map(HeaterDTO::new).collect(Collectors.toList());
   }

    @Override
    public HeaterDTO addNewHeater(HeaterDTO heaterDTO) {
        HeaterEntity heater = null;
       heaterRepository.save(new HeaterEntity(heaterDTO.getID(),heaterDTO.getName(),heaterDTO.getHeaterStatus(),heaterDTO.getRoomID(),heaterDTO.getCurrentTemperature(),heaterDTO.getTargetTemperature()));

        return heaterDTO;
    }
}
