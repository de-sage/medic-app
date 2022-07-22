package com.thriveagric.medicapp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class HealthDiagnosis {



    /// <summary>
    /// Diagnosed issue
    /// </summary>
    public DiagnosedIssue Issue;

    /// <summary>
    /// List of suggested doctor specialisations for this issue
    /// </summary>
    public List<DiagnosedSpecialisation> Specialisation;
}
