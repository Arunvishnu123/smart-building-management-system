package com.project.smartbuidingapp.Building;

import javax.persistence.*;

@Entity
@Table(name = "Building")

public class BuildingEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private Long buildingID ;

    private String buildingName;

    private String buildingAddress;

    private String buildingOwner;

    private String storeyNumber;

    private String buildingType;

    private Long  buildingSize;

    private Integer buildingAge;

    public BuildingEntity() {
    }

    public BuildingEntity(Long ID, Long buildingID, String buildingName, String buildingAddress, String buildingOwner, String storeyNumber, String buildingType, Long buildingSize, Integer buildingAge) {
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

    public BuildingEntity(BuildingDTO dto) {
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
}