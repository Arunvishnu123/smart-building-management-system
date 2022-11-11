package com.project.smartbuidingapp.Window;

import com.project.smartbuidingapp.CustomType.HeaterStatus;
import com.project.smartbuidingapp.CustomType.WindowStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Windows")

public class WindowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String name ;
    private WindowStatus windowStatus ;
    @Column(name="room_id")
    private Long roomID ;

    public WindowEntity() {
    }

    public WindowEntity(Long ID, String name, WindowStatus windowStatus, Long roomID) {
        this.ID = ID;
        this.name = name;
        this.windowStatus = windowStatus;
        this.roomID = roomID;
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

    public WindowStatus getWindowStatus() {
        return windowStatus;
    }

    public void setWindowStatus(WindowStatus windowStatus) {
        this.windowStatus = windowStatus;
    }

    public Long getRoomID() {
        return roomID;
    }

    public void setRoomID(Long roomID) {
        this.roomID = roomID;
    }
}
