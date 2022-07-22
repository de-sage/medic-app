package com.thriveagric.medicapp.repository;

import com.thriveagric.medicapp.models.Patient;
import com.thriveagric.medicapp.models.SymptomReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymptomReportRepository extends JpaRepository<SymptomReport, Long> {
}
