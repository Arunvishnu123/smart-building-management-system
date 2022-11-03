package com.project.smartbuidingapp.Room;

import com.project.smartbuidingapp.Heater.HeaterEntity;
import com.project.smartbuidingapp.Window.WindowEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    private Long ID;
    private String roomName;
    private Long roomID;
    private float roomTemperature;
    private Long buildingID;
    /*
    @ManyToMany
    private Collection<WindowEntity> windows = new ArrayList<>();
    @ManyToMany
    private Collection<HeaterEntity> heaters = new ArrayList<>();
*/

    public RoomDTO(RoomEntity roomEntity) {
        this.ID = roomEntity.getID();
        this.roomName = roomEntity.getRoomName();
        this.roomID = roomEntity.getRoomID();
        this.roomTemperature = roomEntity.getRoomTemperature();
        this.buildingID = roomEntity.getBuildingID();
    }
}
