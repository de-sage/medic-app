package com.thriveagric.medicapp.dto;

import com.thriveagric.medicapp.models.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class DiagnosisDto {

    private Long id;

    private String name;

    Gender gender;

    private Long age;

    private List<Integer> symptomId;
}
