package com.thriveagric.medicapp.controller;

import com.thriveagric.medicapp.dto.DiagnosisDto;
import com.thriveagric.medicapp.dto.HealthItem;
import com.thriveagric.medicapp.models.Diagnosis;
import com.thriveagric.medicapp.models.Patient;
import com.thriveagric.medicapp.repository.DiagnosisRepository;
import com.thriveagric.medicapp.repository.PatientRepository;
import com.thriveagric.medicapp.service.MedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class DiagnosisController {

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    MedicService medicService;
    

    @GetMapping({"/showDiagnosis", "/list"})
    public ModelAndView getAllDiagnosis()  {

        ModelAndView mav = new ModelAndView("list-diagnosis");
        mav.addObject("diagnosis", diagnosisRepository.findAll());
        return mav;
    }

    @GetMapping({"/search",  "/",})
    public ModelAndView getDiagnosisByIsValid(Diagnosis diagnosis, Model model, String keyword) {

        ModelAndView mav = new ModelAndView("diagnosis-search");

        if(keyword!=null) {
            List<Diagnosis> list = medicService.findByIsValid(keyword);
            model.addAttribute("diagnosis", list);
        } else {
            List<Diagnosis> list = diagnosisRepository.findAll();
            mav.addObject("diagnosis", list);
        }

        return mav;
    }

    @GetMapping({"/perform-diagnosis"})
    public ModelAndView performDiagnosis() {
        ModelAndView mav = new ModelAndView("get-diagnosis");
        mav.addObject("patient", patientRepository.findAll());
        mav.addObject("chosenSymptom", new DiagnosisDto(0L, new ArrayList<>()));
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
    public String getDiagnosis(@ModelAttribute("chosenSymptom") DiagnosisDto healthItem) throws Exception {
        Diagnosis diagnosis =  medicService.getDiagnosis(healthItem);

        return "redirect:/edit/" + diagnosis.getId();
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Optional<Diagnosis> diagnosis = diagnosisRepository.findById(id);

        model.addAttribute("diagnosis", diagnosis.get());
        return "update-patient-diagnosis";
    }

    @PostMapping("/update/{id}")
    public String updateDiagnosis(@PathVariable("id") long id, Diagnosis diagnosis) {
                diagnosisRepository.save(diagnosis);
            return "redirect:/";
    }

}
