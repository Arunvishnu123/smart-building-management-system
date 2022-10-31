package com.project.smartbuidingapp.Building;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BuildingRepository extends JpaRepository<BuildingEntity,Long> {
}
