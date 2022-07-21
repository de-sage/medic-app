package com.thriveagric.medicapp.repository;

import com.thriveagric.medicapp.models.Diagnosis;
import com.thriveagric.medicapp.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
