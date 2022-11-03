package com.project.smartbuidingapp.Window;

import com.project.smartbuidingapp.CustomType.WindowStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class WindowServiceImplementation implements WindowService {


    @Autowired
    private final WindowRepository windowRepository;


    @Override
    public List<WindowDto> getAllWindows() {
        return windowRepository.findAll().stream().map(WindowDto::new).collect(Collectors.toList());
    }

    @Override
    public WindowDto getWindowById(Long Id) {
        return windowRepository.findById(Id).map(WindowDto::new).orElse(null);
    }

    @Override
    public void deleteWindowByID(Long Id) {
       windowRepository.deleteById(Id);
    }

    @Override
    public WindowEntity changeWindowStatusById(Long ID) {
        WindowEntity window = windowRepository.findById(ID).orElseThrow(IllegalArgumentException::new);
      window.setWindowStatus (window.getWindowStatus() == WindowStatus.CLOSE ? WindowStatus.OPEN : WindowStatus.CLOSE);
        return window;
    }

    @Override
    public List<WindowDto> getWindowsFromRoomID(Long roomID) {
        return windowRepository.findByRoomID(roomID).stream().map(WindowDto::new).collect(Collectors.toList());
    }

    @Override
    public WindowDto addNewWindow(WindowDto windowDTO) {
        WindowEntity window = null;
        windowRepository.save(new WindowEntity(windowDTO.getID(),windowDTO.getName(),windowDTO.getWindowStatus(),windowDTO.getRoomID()));

        return windowDTO;
    }
}
