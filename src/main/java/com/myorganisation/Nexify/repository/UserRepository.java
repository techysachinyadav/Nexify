package com.myorganisation.Nexify.repository;

import com.myorganisation.Nexify.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Long> {
}
