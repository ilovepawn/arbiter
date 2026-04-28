package com.ilovepawn.arbiter.user.repository;

import com.ilovepawn.arbiter.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByKeycloakSub(String keycloakSub);
}
