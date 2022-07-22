package com.thriveagric.medicapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.thriveagric.medicapp.models.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiagnosisDto {
    private Long patientId;
    private List<Integer> symptomId;
}
