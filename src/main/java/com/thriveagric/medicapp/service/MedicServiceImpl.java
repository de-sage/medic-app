package com.thriveagric.medicapp.service;

import com.thriveagric.medicapp.dto.HealthDiagnosis;
import com.thriveagric.medicapp.dto.HealthItem;
import com.thriveagric.medicapp.models.Diagnosis;
import com.thriveagric.medicapp.models.Patient;
import com.thriveagric.medicapp.repository.DiagnosisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicServiceImpl implements MedicService {


    @Autowired
    DiagnosisRepository diagnosisRepository;


    @Value("${auth.service}")
    String authUrl;

    @Value("${health.service}")
    String basePath;

    @Value("${username}")
    String userLogin;

    @Value("${password}")
    String userPassword;

    @Value("${language}")
    String language;


    public List<HealthItem> getAllSymptoms() throws Exception {

        System.out.println("pass =========================" + userPassword);
        System.out.println("user =========================" + userLogin);
        System.out.println("url =========================" + authUrl);
        System.out.println("la =========================" + language);
        System.out.println("path =========================" + basePath);



        DiagnosisClient diagnosisClient = new DiagnosisClient(userLogin + "1@gmail.com", userPassword, authUrl, "en-gb", basePath);
         List<HealthItem> healthItems = diagnosisClient.loadSymptoms();

         for(HealthItem healthItem : healthItems) {
             System.out.println(healthItem.toString());
         }
        return healthItems;

    }

    public List<HealthItem> getAllBodyParts() throws Exception {

        System.out.println("pass =========================" + userPassword);
        System.out.println("user =========================" + userLogin);
        System.out.println("url =========================" + authUrl);
        System.out.println("la =========================" + language);
        System.out.println("path =========================" + basePath);



        DiagnosisClient diagnosisClient = new DiagnosisClient(userLogin + "1@gmail.com", userPassword, authUrl, "en-gb", basePath);
        List<HealthItem> healthItems = diagnosisClient.loadBodyLocations();

        for(HealthItem healthItem : healthItems) {
            System.out.println(healthItem.toString());
        }
        return healthItems;
    }

    @Override
    public Diagnosis getDiagnosis(Patient patient, int healthItem) throws Exception {
        System.out.println("pass =========================" + userPassword);
        System.out.println("user =========================" + userLogin);
        System.out.println("url =========================" + authUrl);
        System.out.println("la =========================" + language);
        System.out.println("path =========================" + basePath);

        System.out.println("patient" + patient.toString());

        List<Integer> symptoms = new ArrayList<>();
        symptoms.add(healthItem);
//        for(HealthItem healthItem1 : healthItem) {
//            System.out.println("symptoms" + healthItem1.toString());
//            symptoms.add(healthItem1.getID());
//        }
        DiagnosisClient diagnosisClient = new DiagnosisClient(userLogin + "1@gmail.com", userPassword, authUrl, "en-gb", basePath);
        List<HealthDiagnosis> healthItems = diagnosisClient.loadDiagnosis(symptoms, patient.getGender(), Math.toIntExact(patient.getAge()));
        HealthDiagnosis diagnosis = healthItems.get(0);
        Diagnosis build = Diagnosis.builder().accuracy(diagnosis.Issue.Accuracy).name(diagnosis.Issue.IcdName).profName(diagnosis.Issue.ProfName).build();
        build.setPatient(patient);

        return diagnosisRepository.save(build);
    }

}
