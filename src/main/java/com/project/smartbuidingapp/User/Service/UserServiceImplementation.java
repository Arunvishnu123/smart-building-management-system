package com.project.smartbuidingapp.User.Service;

import com.project.smartbuidingapp.User.Model.AppUser;
import com.project.smartbuidingapp.User.Model.Role;
import com.project.smartbuidingapp.User.Repository.RoleRepository;
import com.project.smartbuidingapp.User.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImplementation implements UserService {

    private  final UserRepository userRepository;
    private  final RoleRepository roleRepository;

    @Override
    public AppUser saveUser(AppUser appUser) {
        log.info("Saving new user {} to the database", appUser.getName());
        return userRepository.save(appUser);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        log.info("adding role{} to user {}", roleName,  userName);
        AppUser user = userRepository.findByUsername(userName);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);

    }

    @Override
    public AppUser getUser(String userName) {
        log.info("fetching user {}", userName);
        return userRepository.findByUsername((userName));
    }

    @Override
    public List<AppUser> getUser() {
        log.info("get all users");
        return userRepository.findAll();
    }
}
