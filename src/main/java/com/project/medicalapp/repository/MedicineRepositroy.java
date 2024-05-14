package com.project.medicalapp.repository;

import com.project.medicalapp.model.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepositroy extends JpaRepository<Medicine,Long> {
}
