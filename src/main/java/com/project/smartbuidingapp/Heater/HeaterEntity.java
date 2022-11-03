package com.project.smartbuidingapp.Heater;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Building")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeaterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String name ;
    private String name1 ;
    private String name23 ;
    private String name4 ;

}
