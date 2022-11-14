package com.project.smartbuidingapp.Room;

import com.project.smartbuidingapp.Heater.HeaterEntity;
import com.project.smartbuidingapp.User.Model.Role;
import com.project.smartbuidingapp.Window.WindowEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@Table(name = "Rooms")

public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String roomName;
    @Column(name="room_id")
    private Long roomID;
    private float roomTemperature;
    @Column(name="building_id")
    private Long buildingID;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    private List<HeaterEntity> heaters ;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    private List<WindowEntity> windows;
    public RoomEntity() {
    }

    public RoomEntity(Long ID, String roomName, Long roomID, float roomTemperature, Long buildingID, List<HeaterEntity> heaters, List<WindowEntity> windows) {
        this.ID = ID;
        this.roomName = roomName;
        this.roomID = roomID;
        this.roomTemperature = roomTemperature;
        this.buildingID = buildingID;
        this.heaters = heaters;
        this.windows = windows;
    }

    public RoomEntity(Long ID, String roomName, Long roomID, float roomTemperature, Long buildingID) {
        this.ID = ID;
        this.roomName = roomName;
        this.roomID = roomID;
        this.roomTemperature = roomTemperature;
        this.buildingID = buildingID;
    }

    public List<HeaterEntity> getHeaters() {
        return heaters;
    }

    public void setHeaters(List<HeaterEntity> heaters) {
        this.heaters = heaters;
    }

    public List<WindowEntity> getWindows() {
        return windows;
    }

    public void setWindows(List<WindowEntity> windows) {
        this.windows = windows;
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
