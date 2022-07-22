package com.thriveagric.medicapp.repository;

import com.thriveagric.medicapp.models.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {
    Optional<Diagnosis> findTopByOrderByDiagnosisDateDesc();
}
