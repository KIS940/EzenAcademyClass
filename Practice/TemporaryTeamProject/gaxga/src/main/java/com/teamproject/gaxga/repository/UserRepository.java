package com.teamproject.gaxga.repository;

import com.teamproject.gaxga.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByGaId(String gaId);
    boolean existsByGaId(String gaId);
    User findByGaNickAndGaPhone(String gaNick, String gaPhone);
    boolean existsByGaNick(String gaNick);
    boolean existsByGaPhone(String gaPhone);
}
