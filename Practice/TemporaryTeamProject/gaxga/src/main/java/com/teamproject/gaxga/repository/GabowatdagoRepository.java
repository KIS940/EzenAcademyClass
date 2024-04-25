package com.teamproject.gaxga.repository;

import com.teamproject.gaxga.entity.Gabowatdago;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface GabowatdagoRepository extends CrudRepository<Gabowatdago, Long> {
    @Override
    ArrayList<Gabowatdago> findAll();
}
