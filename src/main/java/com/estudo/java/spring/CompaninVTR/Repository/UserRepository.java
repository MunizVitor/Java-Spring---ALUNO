package com.estudo.java.spring.CompaninVTR.Repository;

import com.estudo.java.spring.CompaninVTR.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserRepository extends IEntityRepository<User> {
    UserDetails findByLogin(String login);
    UserDetails findByLoginAndIsAtivoTrue(String login);
}
