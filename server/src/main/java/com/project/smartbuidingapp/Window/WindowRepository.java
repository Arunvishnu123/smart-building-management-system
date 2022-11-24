package com.project.smartbuidingapp.Window;

import com.project.smartbuidingapp.Heater.HeaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WindowRepository extends JpaRepository<WindowEntity, Long> {
    List<WindowEntity> findByRoomID(Long roomID);

}
