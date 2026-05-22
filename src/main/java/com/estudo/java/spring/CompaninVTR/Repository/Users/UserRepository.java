package com.estudo.java.spring.CompaninVTR.Repository.Users;

import com.estudo.java.spring.CompaninVTR.Model.Users.User;
import com.estudo.java.spring.CompaninVTR.Repository.IEntityRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends IEntityRepository<User> {

    UserDetails findByLoginAndIsAtivoTrue(String login);
}
