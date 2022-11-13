package com.project.smartbuidingapp.Building;

import com.project.smartbuidingapp.ResponseClass.BuildingResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class BuildingServiceTest {


    private BuildingService underTest;

    @Mock
    private BuildingRepository buildingRepository;

    @InjectMocks
    private BuildingServiceImplementation buildingService ;

    private BuildingEntity buildingEntity ;

    @BeforeEach
    void setUp(){
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
    void canGetAllBuilding(){
      BuildingEntity  buildingEntity1 = BuildingEntity.builder()
                .buildingID(4L)
                .ID(2L)
                .buildingAddress("Saint-Etienne")
                .buildingAge(9)
                .buildingName("Test1")
                .buildingSize(43L)
                .buildingType("Structural")
                .buildingOwner("Arun")
                .storeyNumber("6").build();

        given(buildingRepository.findAll()).willReturn(List.of(buildingEntity,buildingEntity1));
        List<BuildingDto> buildingList = buildingService.getAllBuildings();

        assertThat(buildingList).isNotNull();
        assertThat(buildingList.size()).isEqualTo(2);

    }

    @Test
    void canGetBuildingEmptyList(){
        BuildingEntity  buildingEntity1 = BuildingEntity.builder()
                .buildingID(4L)
                .ID(2L)
                .buildingAddress("Saint-Etienne")
                .buildingAge(9)
                .buildingName("Test1")
                .buildingSize(43L)
                .buildingType("Structural")
                .buildingOwner("Arun")
                .storeyNumber("6").build();
        given(buildingRepository.findAll()).willReturn(Collections.emptyList());

        List<BuildingDto> buildingList = buildingService.getAllBuildings();

        assertThat(buildingList).isEmpty();
        assertThat(buildingList.size()).isEqualTo(0);
    }

    @Test
    void canGetBuildingById(){
        //given
        given(buildingRepository.findById(1L)).willReturn(Optional.of(buildingEntity));
       //when
        BuildingDto getBuildingById = buildingService.getBuildingByID(buildingEntity.getID());
        // then
        assertThat(getBuildingById).isNotNull();

    }

    @Test
    void canSaveBuilding(){
        //given
        BuildingPost buildingEntity1 = new BuildingPost( 2L,5L, "Mines", "Saint-Etienne", "Arun", "9", "structural", 1000L, 8);
        //when
        buildingService.addNewBuilding(buildingEntity1);
        //then
        assertThat(buildingRepository.findById(2L)).isNotNull();

    }




}
