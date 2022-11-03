package com.project.smartbuidingapp.Heater;

import com.project.smartbuidingapp.Building.BuildingDTO;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HeaterServiceImplementation implements HeaterService{

    private final HeaterRepository heaterRepository;

    @Override
    public List<BuildingDTO> getAllHeaters() {
        return null;
    }
}
