package com.project.smartbuidingapp.User.Controller;

import com.project.smartbuidingapp.User.Model.AppUser;
import com.project.smartbuidingapp.User.Model.LoginUser;
import com.project.smartbuidingapp.User.Model.Role;
import com.project.smartbuidingapp.User.Model.RoletoUserForm;
import com.project.smartbuidingapp.User.Service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@SecurityRequirement(name = "javainuseapi")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService ;

    @PostMapping("/login")
    public String login( LoginUser loginUser){
        return "login";
    }

    @PostMapping("/logout")
    public String logout( ){
        return "logout successfull";
    }
    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getUser(){
        return  ResponseEntity.ok().body(userService.getUser());
    }

    @PostMapping("/users/save")
    public ResponseEntity<AppUser>  saveUser(@RequestBody AppUser appUser){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/auth/user/save").toUriString());
        return  ResponseEntity.created(uri).body(userService.saveUser(appUser));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/auth/role/save").toUriString());
        return  ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoletoUserForm role){
        userService.addRoleToUser(role.getUsername(), role.getRoleName());
        return  ResponseEntity.ok().build();
    }




}



