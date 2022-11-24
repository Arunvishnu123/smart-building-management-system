package com.project.smartbuidingapp.Heater;

import com.project.smartbuidingapp.Building.BuildingEntity;
import com.project.smartbuidingapp.Building.BuildingRepository;
import com.project.smartbuidingapp.Room.RoomEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static com.project.smartbuidingapp.CustomType.HeaterStatus.OFF;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class HeaterRepositoryTest {
    @Autowired
    private HeaterRepository heaterRepositoryUnderTest;
    @BeforeEach
    void setUp(){

    }

    @Test
    void canFindByRoomID(){
        Long roomID = 1L;
        HeaterEntity heaterEntity = new HeaterEntity(1L,"name", OFF , 1L , 45F, 45F );
        heaterRepositoryUnderTest.save(heaterEntity);

      List<HeaterEntity> heaterEntity1 =  heaterRepositoryUnderTest.findByRoomID(1L);
        assertThat(heaterEntity1.size()).isEqualTo(1);
    }

}
