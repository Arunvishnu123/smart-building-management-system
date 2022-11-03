package com.project.smartbuidingapp.Room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    private Long ID;
    private String roomName;
    private Long roomID;
    private float roomTemperature;
    private Long buildingID;

    public RoomDTO(RoomEntity roomEntity) {
        this.ID = roomEntity.getID();
        this.roomName = roomEntity.getRoomName();
        this.roomID = roomEntity.getRoomID();
        this.roomTemperature = roomEntity.getRoomTemperature();
        this.buildingID = roomEntity.getBuildingID();
    }
}
