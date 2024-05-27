package com.teamproject.gaxga.repository.gabojago;

import com.teamproject.gaxga.entity.gabojago.GI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GiRepository extends JpaRepository<GI,Long> {
    @Query("SELECT name FROM GI")
    List<String> findAllNames();
}
