package com.project.smartbuidingapp.Window;

import com.project.smartbuidingapp.CustomType.WindowStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
