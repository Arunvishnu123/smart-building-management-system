package com.project.smartbuidingapp.Heater;

import com.project.smartbuidingapp.CustomType.HeaterStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeaterDTO {
    private Long ID;
    private String name ;
    private HeaterStatus  heaterStatus ;
    private Long  roomID ;
    private Float currentTemperature ;
    private Float targetTemperature;


    public HeaterDTO(HeaterEntity heaterEntity) {
        this.ID = heaterEntity.getID();
        this.name = heaterEntity.getName();
        this.heaterStatus = heaterEntity.getHeaterStatus();
        this.roomID = heaterEntity.getRoomID();
        this.currentTemperature = heaterEntity.getCurrentTemperature();
        this.targetTemperature = heaterEntity.getTargetTemperature();
    }
}
