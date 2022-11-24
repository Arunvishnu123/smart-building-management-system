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
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;

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
                .buildingID(1L)
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
       RoomEntity roomEntity1 = RoomEntity.builder()
                .ID(1L)
                .roomID(1L)
                .roomTemperature(23.3F)
                .roomName("Mines")
                .buildingID(1L)
                .build();

       given(roomRepository.findAll()).willReturn(List.of(roomEntity,roomEntity1));
       List<RoomDto> roomList = roomService.getAllRooms();

       assertThat(roomList).isNotNull();
       assertThat(roomList.size()).isEqualTo(2);

    }

    @Test
    void canGetRoomByBuildingID(){
        given(roomRepository.findByBuildingID(1L)).willReturn(List.of(roomEntity));

        List<RoomDto> getRoomByBuildingID = roomService.getAllRoomByBuildingID(buildingEntity.getBuildingID());

        assertThat(getRoomByBuildingID.size()).isEqualTo(1);


    }


}
