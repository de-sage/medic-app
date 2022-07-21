package com.thriveagric.medicapp.controller;

import com.thriveagric.medicapp.dto.DiagnosisDto;
import com.thriveagric.medicapp.dto.HealthItem;
import com.thriveagric.medicapp.models.Gender;
import com.thriveagric.medicapp.models.Patient;
import com.thriveagric.medicapp.repository.DiagnosisRepository;
import com.thriveagric.medicapp.repository.PatientRepository;
import com.thriveagric.medicapp.service.MedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DiagnosisController {

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    MedicService medicService;
    

    @GetMapping({"/showDiagnosis", "/", "/list"})
    public ModelAndView getAllDiagnosis()  {

        ModelAndView mav = new ModelAndView("list-diagnosis");
        mav.addObject("diagnosis", diagnosisRepository.findAll());
        return mav;
    }

    @GetMapping({"/perform-diagnosis/{id}"})
    public ModelAndView performDiagnosis() {
        ModelAndView mav = new ModelAndView("get-diagnosis");
        mav.addObject("patient", patientRepository.findAll());
        try {
            List<HealthItem> healthItems = new ArrayList<>(medicService.getAllSymptoms());
            mav.addObject("bodyParts", healthItems);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    @GetMapping("/addPatient")
    public ModelAndView addPatientForm() {
        ModelAndView mav = new ModelAndView("add-patient-form");
        Patient newPatient = new Patient();
        mav.addObject("patient", newPatient);
        return mav;
    }

    @PostMapping("/savePatient")
    public String savePatient(@ModelAttribute Patient patient) {
        patientRepository.save(patient);
        return "redirect:/perform-diagnosis";
    }
    @PostMapping("/getDiagnosis")
    public String getDiagnosis(@ModelAttribute DiagnosisDto healthItem) throws Exception {
//        List<HealthItem> healthItems = new ArrayList<>();
//        healthItems.add(healthItem);
//        Patient patient = Patient.builder().age(22L).gender(Gender.MALE).name("Gideo").build();
//        medicService.getDiagnosis(patient, healthItem);
        return "worked";
    }
}
