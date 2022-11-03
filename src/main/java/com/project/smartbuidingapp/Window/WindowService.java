package com.project.smartbuidingapp.Window;

import com.project.smartbuidingapp.Heater.HeaterDTO;
import com.project.smartbuidingapp.Heater.HeaterEntity;

import java.util.List;

public interface WindowService {
    List<WindowDTO> getAllWindows();
    WindowDTO getWindowById(Long Id);
    void deleteWindowByID(Long Id);
    WindowEntity changeWindowStatusById(Long ID);

    List<WindowDTO> getWindowsFromRoomID(Long roomID);

    WindowDTO addNewWindow(WindowDTO windowDTO);


}
