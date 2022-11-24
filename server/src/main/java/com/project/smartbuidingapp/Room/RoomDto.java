package com.project.smartbuidingapp.Room;


import com.project.smartbuidingapp.Heater.HeaterEntity;
import com.project.smartbuidingapp.Window.WindowEntity;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RoomDto {
    private Long ID;
    private String roomName;

    private Long roomID;
    private float roomTemperature;
    private Long buildingID;


    private List<HeaterEntity> heaters;


    private List<WindowEntity> windows;


    public RoomDto(RoomEntity roomEntity) {
        this.ID = roomEntity.getID();
        this.roomName = roomEntity.getRoomName();
        this.roomID = roomEntity.getRoomID();
        this.roomTemperature = roomEntity.getRoomTemperature();
        this.buildingID = roomEntity.getBuildingID();
        this.windows = roomEntity.getWindows();
        this.heaters = roomEntity.getHeaters();
    }

    public RoomDto(Long ID, String roomName, Long roomID, float roomTemperature, Long buildingID, List<HeaterEntity> heaters, List<WindowEntity> windows) {
        this.ID = ID;
        this.roomName = roomName;
        this.roomID = roomID;
        this.roomTemperature = roomTemperature;
        this.buildingID = buildingID;
        this.heaters = heaters;
        this.windows = windows;
    }

    public RoomDto() {
    }

    public RoomDto(Long ID, String roomName, Long roomID, float roomTemperature, Long buildingID) {
        this.ID = ID;
        this.roomName = roomName;
        this.roomID = roomID;
        this.roomTemperature = roomTemperature;
        this.buildingID = buildingID;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Long getRoomID() {
        return roomID;
    }

    public void setRoomID(Long roomID) {
        this.roomID = roomID;
    }

    public Collection<HeaterEntity> getHeaters() {
        return heaters;
    }

    public void setHeaters(List<HeaterEntity> heaters) {
        this.heaters = heaters;
    }

    public Collection<WindowEntity> getWindows() {
        return windows;
    }

    public void setWindows(List<WindowEntity> windows) {
        this.windows = windows;
    }

    public float getRoomTemperature() {
        return roomTemperature;
    }

    public void setRoomTemperature(float roomTemperature) {
        this.roomTemperature = roomTemperature;
    }

    public Long getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(Long buildingID) {
        this.buildingID = buildingID;
    }
}
