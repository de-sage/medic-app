package com.thriveagric.medicapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@ToString
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Patient {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    Gender gender;

    private Long age;

    @OneToMany(
            mappedBy = "patient",
            cascade = CascadeType.ALL)
    List<Diagnosis> diagnosis;

    @OneToMany(
            mappedBy = "patient",
            cascade = CascadeType.ALL)
    List<SymptomReport> symptomReports;

    public void addSymptomReports(SymptomReport symptomReportParam) {
        symptomReports.add(symptomReportParam);
        symptomReportParam.setPatient(this);
    }

    public void removeSymptomReports(SymptomReport symptomReportParam) {
        symptomReports.remove(symptomReportParam);
        symptomReportParam.setPatient(null);
    }


    public void addDiagnosis(Diagnosis diagnosisParam) {
        diagnosis.add(diagnosisParam);
        diagnosisParam.setPatient(this);
    }

    public void removeDiagnosis(Diagnosis diagnosisParam) {
        diagnosis.remove(diagnosisParam);
        diagnosisParam.setPatient(null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
