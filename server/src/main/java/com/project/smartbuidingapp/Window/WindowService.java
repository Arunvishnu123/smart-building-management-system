package com.project.smartbuidingapp.Window;

import com.project.smartbuidingapp.ResponseClass.WindowResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WindowService {
    List<WindowDto> getAllWindows();
    WindowDto getWindowById(Long Id);
    void deleteWindowByID(Long Id);
    WindowEntity changeWindowStatusById(Long ID);

    List<WindowDto> getWindowsFromRoomID(Long roomID);

    ResponseEntity<WindowResponse> addNewWindow(WindowDto windowDTO);


}
