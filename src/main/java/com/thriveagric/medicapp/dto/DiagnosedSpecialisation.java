package com.thriveagric.medicapp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class DiagnosedSpecialisation {

    public int ID;

    public String Name;

    /// <summary>
    /// ID of specialisation
    /// </summary>
    public Integer SpecialistID;

    /// <summary>
    /// Accuracy of specialisation
    /// </summary>
    public float Accuracy;

    /// <summary>
    /// Ranking of specialisation
    /// </summary>
    public String Ranking;
}
