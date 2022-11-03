package com.project.smartbuidingapp.Window;

import com.project.smartbuidingapp.CustomType.HeaterStatus;
import com.project.smartbuidingapp.CustomType.WindowStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Windows")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WindowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String name ;
    private WindowStatus windowStatus ;
    private Long roomID ;

}
