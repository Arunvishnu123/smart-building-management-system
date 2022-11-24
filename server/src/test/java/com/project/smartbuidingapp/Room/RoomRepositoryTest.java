package com.project.smartbuidingapp.Room;

import com.project.smartbuidingapp.Building.BuildingEntity;
import com.project.smartbuidingapp.Building.BuildingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class RoomRepositoryTest {
    @Autowired
    private RoomRepository roomRepositoryUnderTest;

    @Autowired
    private BuildingRepository buildingRepository;

    @Test
    void canFindRoomByBuildingId(){
        Long buildingID = 1L;
        BuildingEntity buildingEntity = new BuildingEntity( buildingID,3L, "Mines", "Saint-Etienne", "Arun", "9", "structural", 1000L, 8);
        buildingRepository.save(buildingEntity);

        RoomEntity roomEntity = new RoomEntity(1L,"test",2L, 435,buildingID );
        List<RoomEntity> roomEntities = new ArrayList<>();
        roomEntities.add(roomEntity);
        roomRepositoryUnderTest.save(roomEntity);

        List<RoomEntity> roomEntity1 = roomRepositoryUnderTest.findByBuildingID(buildingID);
        assertThat(roomEntity1.get(0).getBuildingID()).isEqualTo(buildingID);
    }




}
