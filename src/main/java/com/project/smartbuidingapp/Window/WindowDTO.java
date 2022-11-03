package com.project.smartbuidingapp.Window;

import com.project.smartbuidingapp.CustomType.WindowStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class WindowDTO {
    private Long ID;
    private String name ;
    private WindowStatus windowStatus ;
    private Long roomID ;


    public WindowDTO(WindowEntity windowEntity) {
        this.ID = windowEntity.getID();
        this.name = windowEntity.getName();
        this.windowStatus = windowEntity.getWindowStatus();
        this.roomID = windowEntity.getRoomID();
    }

    public WindowDTO() {
    }

    public WindowDTO(Long ID, String name, WindowStatus windowStatus, Long roomID) {
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
