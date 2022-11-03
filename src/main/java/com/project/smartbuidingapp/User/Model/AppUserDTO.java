package com.project.smartbuidingapp.User.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class AppUserDTO {
    private Long id;
    private String name ;
    private String username;
    private String password;

    public AppUserDTO(AppUser appUser) {
        this.id = appUser.getId();
        this.name = appUser.getName();
        this.username = appUser.getUsername();
        this.password = appUser.getPassword();
    }
}
