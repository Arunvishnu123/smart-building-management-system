package com.project.smartbuidingapp.Window;

import java.util.List;

public interface WindowService {
    List<WindowDto> getAllWindows();
    WindowDto getWindowById(Long Id);
    void deleteWindowByID(Long Id);
    WindowEntity changeWindowStatusById(Long ID);

    List<WindowDto> getWindowsFromRoomID(Long roomID);

    WindowDto addNewWindow(WindowDto windowDTO);


}
