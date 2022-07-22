package com.thriveagric.medicapp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Setter
@Getter
@ToString
public class HealthSymptomSelector {

    ///<summary>
    /// Professional name
    /// </summary>
    public String ProfName;

    /// <summary>
    /// Red flag indicator
    /// </summary>
    public Boolean HasRedFlag;

    /// <summary>
    /// List of sublocation ids where this symptom is shown
    /// </summary>
    public List<Integer> HealthSymptomLocationIDs;

    /// <summary>
    /// Symptom synonyms (comma separated)
    /// </summary>
    public List<String> Synonyms;
}
