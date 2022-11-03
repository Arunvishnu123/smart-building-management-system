package com.project.smartbuidingapp.Heater;

import com.project.smartbuidingapp.CustomType.HeaterStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Heater")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeaterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String name ;
    private HeaterStatus heaterStatus ;
    private Long roomID ;
    private Float currentTemperature ;
    private Float targetTemperature;

}
