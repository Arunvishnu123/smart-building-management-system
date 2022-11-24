package com.project.smartbuidingapp.Building;

import com.project.smartbuidingapp.Room.RoomEntity;
import org.junit.jupiter.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
@DataJpaTest
public class BuildingRepositoryTest {

    @Autowired
    private BuildingRepository buildingRepositoryUnderTest;

    @Test
    void canFindByBuildingName(){
        String buildingName = "mines";
        BuildingEntity buildingEntity = new BuildingEntity( 1L,3L, buildingName, "Saint-Etienne", "Arun", "9", "structural", 1000L, 8);
        buildingRepositoryUnderTest.save(buildingEntity);

        BuildingEntity buildingEntity1 =  buildingRepositoryUnderTest.findByBuildingName(buildingName);
        assertThat(buildingEntity1.getID()).isEqualTo(buildingEntity.getID());
    }
    @Test
    void canFindByBuildingID(){
      Long buildingID = 6L;
        BuildingEntity buildingEntity = new BuildingEntity( 1L,buildingID , "mines", "Saint-Etienne", "Arun", "9", "structural", 1000L, 8);
        buildingRepositoryUnderTest.save(buildingEntity);

        BuildingEntity buildingEntity1 =  buildingRepositoryUnderTest.findByBuildingID(buildingID);
        assertThat(buildingEntity1.getBuildingID()).isEqualTo(buildingEntity.getBuildingID());
    }


}
