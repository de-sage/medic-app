package com.thriveagric.medicapp.service;

import com.thriveagric.medicapp.dto.DiagnosisDto;
import com.thriveagric.medicapp.dto.HealthDiagnosis;
import com.thriveagric.medicapp.dto.HealthItem;
import com.thriveagric.medicapp.models.Diagnosis;
import com.thriveagric.medicapp.models.Patient;

import java.util.List;

public interface MedicService {

    public List<HealthItem> getAllSymptoms() throws Exception;

    public Diagnosis getDiagnosis(DiagnosisDto diagnosisDtos) throws Exception;
}
