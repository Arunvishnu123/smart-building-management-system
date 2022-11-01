package com.project.smartbuidingapp.User.Service;

import com.project.smartbuidingapp.User.Model.AppUser;
import com.project.smartbuidingapp.User.Model.Role;
import com.project.smartbuidingapp.User.Repository.RoleRepository;
import com.project.smartbuidingapp.User.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImplementation implements UserService, UserDetailsService {

    private  final UserRepository userRepository;
    private  final RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepository.findByUsername(username);
        if(user==null){
            log.error("user not found in the Database");
            throw new UsernameNotFoundException("User not found in the database");
        }else{
            log.info("User found in the database - {}", username);
        }

        Collection<SimpleGrantedAuthority> authorites = new ArrayList<>();
        user.getRoles().forEach(role ->{
            authorites.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorites);
    }
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
