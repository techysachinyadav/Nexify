package com.myorganisation.Nexify.repository;

import com.myorganisation.Nexify.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User , Long> {
   List<User>  findByUsernameContaining (String username );
}
