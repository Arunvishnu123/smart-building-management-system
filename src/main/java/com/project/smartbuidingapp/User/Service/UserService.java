package com.project.smartbuidingapp.User.Service;

import com.project.smartbuidingapp.User.Model.AppUser;
import com.project.smartbuidingapp.User.Model.AppUserDTO;
import com.project.smartbuidingapp.User.Model.Role;

import java.util.List;



public interface UserService {

    AppUser saveUser(AppUserDTO appUser);
    Role saveRole(Role role);
    void addRoleToUser (String userName, String roleName);
    AppUser getUser(String userName);
    List<AppUser>getUser();

}
