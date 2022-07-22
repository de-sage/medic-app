package com.thriveagric.medicapp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class DiagnosedIssue {


    public int ID;


    public String Name;

    /// <summary>
    /// ICD code
    /// </summary>
    public String Icd;

    /// <summary>
    /// ICD name
    /// </summary>
    public String IcdName;

    /// <summary>
    /// Profesional name
    /// </summary>
    public String ProfName;

    /// <summary>
    /// Probability for the issue in %
    /// </summary>
    public float Accuracy;


    public float Ranking;
}
