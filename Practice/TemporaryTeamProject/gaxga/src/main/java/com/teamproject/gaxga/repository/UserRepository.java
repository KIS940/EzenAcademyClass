package com.teamproject.gaxga.repository;

import com.teamproject.gaxga.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByGaId(String gaId);
    User findByInfo(String gaId, String gaPass,
                    String gaNick, String gaPhone,
                    String gaAddress, String gaDetailAddress,
                    String gaEmail, String gaP_Image);
    boolean existsByGaId(String gaId);
}
