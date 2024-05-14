package com.project.medicalapp.repository;

import com.project.medicalapp.model.entity.Adminstration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminstrationRepository extends JpaRepository<Adminstration,Long> {
    Optional<Adminstration> findById(Long id);
}
