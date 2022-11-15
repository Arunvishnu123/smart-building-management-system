package com.project.smartbuidingapp.Room;

import com.project.smartbuidingapp.Building.BuildingEntity;
import com.project.smartbuidingapp.Building.BuildingRepository;
import com.project.smartbuidingapp.Building.BuildingService;
import com.project.smartbuidingapp.Building.BuildingServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@ExtendWith(MockitoExtension.class)
public class RoomServiceTest {

    private RoomService underTest;

    @Mock
    private RoomRepository roomRepository;

    @InjectMocks
    private RoomServiceImplementation roomService ;

    private RoomEntity roomEntity ;

    private BuildingEntity buildingEntity;


    @BeforeEach
    void setUp(){
        roomEntity = RoomEntity.builder()
                .ID(1L)
                .roomID(1L)
                .roomTemperature(23.3F)
                .roomName("Mines")
                .buildingID(1L)
                .build();

        buildingEntity = BuildingEntity.builder()
                .buildingID(3L)
                .ID(1L)
                .buildingAddress("Saint-Etienne")
                .buildingAge(9)
                .buildingName("Mines")
                .buildingSize(43L)
                .buildingType("Structural")
                .buildingOwner("Arun")
                .storeyNumber("9").build();

    }

    @Test
    void canGetRoomList(){

    }


}
