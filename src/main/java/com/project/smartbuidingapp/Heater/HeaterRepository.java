package com.project.smartbuidingapp.Heater;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeaterRepository extends JpaRepository<HeaterEntity, Long> {
}
