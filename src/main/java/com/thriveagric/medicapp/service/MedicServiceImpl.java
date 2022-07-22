package com.thriveagric.medicapp.service;

import com.thriveagric.medicapp.dto.DiagnosisDto;
import com.thriveagric.medicapp.dto.HealthDiagnosis;
import com.thriveagric.medicapp.dto.HealthItem;
import com.thriveagric.medicapp.models.Diagnosis;
import com.thriveagric.medicapp.models.Patient;
import com.thriveagric.medicapp.repository.DiagnosisRepository;
import com.thriveagric.medicapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedicServiceImpl implements MedicService {


    @Autowired
    DiagnosisRepository diagnosisRepository;

    @Autowired
    PatientRepository patientRepository;


    @Value("${medic.api.auth.service}")
    String authUrl;

    @Value("${medic.api.health.service}")
    String basePath;

    @Value("${medic.api.username}")
    String userLogin;

    @Value("${medic.api.password}")
    String userPassword;

    @Value("${medic.api.language}")
    String language;

    @Override
    public Diagnosis getDiagnosis(DiagnosisDto symptoms) throws Exception {
        System.out.println("pass =========================" + userPassword);
        System.out.println("user =========================" + userLogin);
        System.out.println("url =========================" + authUrl);
        System.out.println("la =========================" + language);
        System.out.println("path =========================" + basePath);

        List<>
        for(Integer healthItem1 : symptoms.getSymptomId()) {
            System.out.println("symptoms" + healthItem1);
        }

        System.out.println("Getting Diagnosis for patient with id : " + symptoms.getPatientId());
        Patient patient = patientRepository.getReferenceById(symptoms.getPatientId());
        System.out.println("Getting Diagnosis for : " + patient);


        DiagnosisClient diagnosisClient = new DiagnosisClient(userLogin, userPassword, authUrl, language, basePath);

        List<HealthDiagnosis> healthItems = diagnosisClient.loadDiagnosis(symptoms.getSymptomId(), patient.getGender(), Math.toIntExact(patient.getAge()));

        HealthDiagnosis diagnosis = healthItems.get(0);
        System.out.println(diagnosis.toString());



        Diagnosis build = Diagnosis.builder().name(diagnosis.getIssue().getName()).profName(diagnosis.getIssue().getProfName()).issueId((long) diagnosis.getIssue().getID()).accuracy(diagnosis.getIssue().Accuracy).build();

        build = diagnosisRepository.save(build);
        build.setPatient(patient);
        patient.addDiagnosis(build);
        patientRepository.save(patient);
        return build;
    }

    public List<HealthItem> getAllSymptoms() throws Exception {
        //get from redis cache only get from client once the application restarts
        DiagnosisClient diagnosisClient = new DiagnosisClient(userLogin, userPassword, authUrl, language, basePath);
         List<HealthItem> healthItems = diagnosisClient.loadSymptoms();

         for(HealthItem healthItem : healthItems) {
             System.out.println(healthItem.toString());
         }
        return healthItems;

    }

//    public Diagnosis getLatestDiagnosis() {
//        Optional<Diagnosis> diagnosis = diagnosisRepository.findTopByOrderByDiagnosisDateDesc();
//        return diagnosis.get();
//    }
}
