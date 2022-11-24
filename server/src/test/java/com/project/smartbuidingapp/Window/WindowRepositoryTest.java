package com.project.smartbuidingapp.Window;

import com.project.smartbuidingapp.CustomType.WindowStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static com.project.smartbuidingapp.CustomType.WindowStatus.OPEN;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class WindowRepositoryTest {

    @Autowired
    private WindowRepository windowRepositoryUnderTest;
    @Test
    void canFindByRoomID(){
        Long roomID = 1L;
        WindowEntity windowEntity = new WindowEntity(1L,"name", OPEN , 1L);
        windowRepositoryUnderTest.save(windowEntity);

        List<WindowEntity> heaterEntity1 =  windowRepositoryUnderTest.findByRoomID(1L);
        assertThat(heaterEntity1.size()).isEqualTo(1);
    }
}
