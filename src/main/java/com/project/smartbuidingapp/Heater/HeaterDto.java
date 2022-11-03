package com.project.smartbuidingapp.Heater;

import com.project.smartbuidingapp.CustomType.HeaterStatus;


public class HeaterDto {
    private Long ID;
    private String name ;
    private HeaterStatus  heaterStatus ;
    private Long  roomID ;
    private Float currentTemperature ;
    private Float targetTemperature;

    public HeaterDto() {
    }

    public HeaterDto(Long ID, String name, HeaterStatus heaterStatus, Long roomID, Float currentTemperature, Float targetTemperature) {
        this.ID = ID;
        this.name = name;
        this.heaterStatus = heaterStatus;
        this.roomID = roomID;
        this.currentTemperature = currentTemperature;
        this.targetTemperature = targetTemperature;
    }

    public HeaterDto(HeaterEntity heaterEntity) {
        this.ID = heaterEntity.getID();
        this.name = heaterEntity.getName();
        this.heaterStatus = heaterEntity.getHeaterStatus();
        this.roomID = heaterEntity.getRoomID();
        this.currentTemperature = heaterEntity.getCurrentTemperature();
        this.targetTemperature = heaterEntity.getTargetTemperature();
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }

    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }

    public Long getRoomID() {
        return roomID;
    }

    public void setRoomID(Long roomID) {
        this.roomID = roomID;
    }

    public Float getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(Float currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public Float getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(Float targetTemperature) {
        this.targetTemperature = targetTemperature;
    }
}
