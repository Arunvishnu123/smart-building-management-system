package com.project.smartbuidingapp.Window;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController

@RequestMapping(path = "api/v1")
public class WindowController {
    @Autowired
    private WindowService windowService;


    @PostMapping("/window/new")
    public ResponseEntity<WindowDto> addNewWindow(@RequestBody WindowDto dto){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/Window/new").toUriString());
        return ResponseEntity.created(uri).body(windowService.addNewWindow(dto));
    }
    @GetMapping("/windows")
    public List<WindowDto> getAllWindows(){
        return windowService.getAllWindows();
    }
    @GetMapping("/windows/{roomID}")
    public List<WindowDto> getAllWindowsInSameRoom(@PathVariable("roomID") Long roomID){
        return windowService.getWindowsFromRoomID(roomID);
    }

    @GetMapping("/window/{windowID}")
    public WindowDto getWindowByID(@PathVariable("windowID") Long windowID){
        return windowService.getWindowById(windowID);
    }


    @DeleteMapping("/windows/{windowID}")
    public void deleteWindowById(@PathVariable Long windowID){
        windowService.deleteWindowByID(windowID);
    }

    @PutMapping("/window/{windowID}/status")
    public WindowEntity changeWindowStatus(@PathVariable("windowID") Long windowID){

        return windowService.changeWindowStatusById(windowID);
    }

}
