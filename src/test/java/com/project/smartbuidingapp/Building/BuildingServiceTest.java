package com.project.smartbuidingapp.Building;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.verify;
/*
@ExtendWith(MockitoExtension.class)
public class BuildingServiceTest {

    private BuildingService underTest;

    @Mock
    private BuildingRepository buildingRepository;

    @BeforeEach
    void setUp(){
        underTest = new BuildingService(buildingRepository);
    }


    @Test
    void canGetAllBuilding(){
              underTest.getAllBuildings();
              verify(buildingRepository).findAll();
    }
}
*/