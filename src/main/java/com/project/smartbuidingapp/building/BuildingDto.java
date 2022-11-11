package com.project.smartbuidingapp.Building;

import com.project.smartbuidingapp.Room.RoomEntity;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BuildingDto {

    private Long ID;
    private Long buildingID ;
    private String buildingName;
    private String buildingAddress;
    private String buildingOwner;
    private String storeyNumber;

    private String buildingType;
    private Long  buildingSize;
    private Integer buildingAge;

    private List<RoomEntity> rooms ;

    public BuildingDto() {
    }


    public BuildingDto(Long ID, Long buildingID, String buildingName, String buildingAddress, String buildingOwner, String storeyNumber, String buildingType, Long buildingSize, Integer buildingAge, List<RoomEntity> rooms) {
        this.ID = ID;
        this.buildingID = buildingID;
        this.buildingName = buildingName;
        this.buildingAddress = buildingAddress;
        this.buildingOwner = buildingOwner;
        this.storeyNumber = storeyNumber;
        this.buildingType = buildingType;
        this.buildingSize = buildingSize;
        this.buildingAge = buildingAge;
        this.rooms = rooms;
    }



    public BuildingDto(Long ID, Long buildingID, String buildingName, String buildingAddress, String buildingOwner, String storeyNumber, String buildingType, Long buildingSize, Integer buildingAge) {
        this.ID = ID;
        this.buildingID = buildingID;
        this.buildingName = buildingName;
        this.buildingAddress = buildingAddress;
        this.buildingOwner = buildingOwner;
        this.storeyNumber = storeyNumber;
        this.buildingType = buildingType;
        this.buildingSize = buildingSize;
        this.buildingAge = buildingAge;
    }


    public BuildingDto(BuildingEntity buildingEntity) {
        this.ID = buildingEntity.getID();
        this.buildingID = buildingEntity.getBuildingID();
        this.buildingName = buildingEntity.getBuildingName();
        this.buildingAddress = buildingEntity.getBuildingAddress();
        this.buildingOwner = buildingEntity.getBuildingOwner();
        this.storeyNumber = buildingEntity.getStoreyNumber();
        this.buildingType = buildingEntity.getBuildingType();
        this.buildingSize = buildingEntity.getBuildingSize();
        this.buildingAge = buildingEntity.getBuildingAge();
        this.rooms = buildingEntity.getRoom();
    }






    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(Long buildingID) {
        this.buildingID = buildingID;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingAddress() {
        return buildingAddress;
    }

    public void setBuildingAddress(String buildingAddress) {
        this.buildingAddress = buildingAddress;
    }

    public String getBuildingOwner() {
        return buildingOwner;
    }

    public void setBuildingOwner(String buildingOwner) {
        this.buildingOwner = buildingOwner;
    }

    public String getStoreyNumber() {
        return storeyNumber;
    }

    public void setStoreyNumber(String storeyNumber) {
        this.storeyNumber = storeyNumber;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public Long getBuildingSize() {
        return buildingSize;
    }

    public void setBuildingSize(Long buildingSize) {
        this.buildingSize = buildingSize;
    }

    public Integer getBuildingAge() {
        return buildingAge;
    }

    public void setBuildingAge(Integer buildingAge) {
        this.buildingAge = buildingAge;
    }

    public List<RoomEntity> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomEntity> rooms) {
        this.rooms = rooms;
    }
}