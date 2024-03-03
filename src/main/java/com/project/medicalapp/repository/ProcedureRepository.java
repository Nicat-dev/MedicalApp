package com.project.medicalapp.repository;

import com.project.medicalapp.model.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedureRepository extends JpaRepository<Procedure,Long> {
}
