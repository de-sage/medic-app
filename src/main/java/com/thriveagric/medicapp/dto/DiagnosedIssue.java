package com.thriveagric.medicapp.dto;

public class DiagnosedIssue {
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
