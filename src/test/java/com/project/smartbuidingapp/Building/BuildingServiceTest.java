package com.project.smartbuidingapp.Building;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BuildingServiceTest {

    private BuildingService underTest;

    @Mock
    private BuildingRepository buildingRepository;

    @BeforeEach
    void setUp(){
        underTest = new BuildingServiceImplementation(buildingRepository);
    }

    @Test
    void canGetAllBuilding(){
              underTest.getAllBuildings();
              verify(buildingRepository).findAll();
    }


}
