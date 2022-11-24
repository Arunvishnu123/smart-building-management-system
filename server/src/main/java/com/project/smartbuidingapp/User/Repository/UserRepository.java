package com.project.smartbuidingapp.User.Repository;

import com.project.smartbuidingapp.User.Model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String userName);

}
