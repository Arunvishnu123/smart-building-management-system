package com.project.smartbuidingapp.User.Controller;

import com.project.smartbuidingapp.User.Model.*;
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

    @GetMapping
    public String startUp(){
        return "<h1>Welcome to Smart Building Management System</h1>";
    }

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
    public ResponseEntity<AppUser>  saveUser(AppUserDto appUserDTO){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(appUserDTO));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/role/save").toUriString());
        return  ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoletoUserForm role){
        userService.addRoleToUser(role.getUsername(), role.getRoleName());
        return  ResponseEntity.ok().build();
    }




}


