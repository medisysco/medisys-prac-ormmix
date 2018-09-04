package my.com.medisys.prac.ormmix.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.com.medisys.prac.ormmix.entity.Patient;
import my.com.medisys.prac.ormmix.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private static final Logger log = LoggerFactory.getLogger(PatientController.class);

    @Autowired
    PatientService service;

    @GetMapping
    public Map<String, Object> findAll(Patient patient) {
        List<Patient> patients = service.selectAll();
        //List<Patient> patients = service.findAll(patient);
        Map<String, Object> res = new HashMap<String, Object>();
        String message = CollectionUtils.isEmpty(patients) ? "No Record Found" : "Records Found";
        
        res.put("message", message);
        res.put("data", patients);
        res.put("success", true);
        return res;
    }

    @GetMapping("/{patientNo}")
    public Map<String, Object> findByPatientNo(@PathVariable("patientNo") Integer patientNo) {
        //Patient patient = service.findByPatientNo(patientNo);
        Patient patient = service.selectByPatientNo(patientNo);
        Map<String, Object> res = new HashMap<String, Object>();
        
        if(!ObjectUtils.isEmpty(patient))
        log.info("Patient Birth Date : {}", patient.getBirthDate());
        String message = ObjectUtils.isEmpty(patient) ? "No Record Found" : "One Record Found";
        
        res.put("message", message);
        res.put("data", patient);
        res.put("success", true);
        return res;
    }

    @PostMapping
    public Map<String, Object> save(@RequestBody Patient patient) {
        patient = service.save(patient);
        Map<String, Object> res = new HashMap<String, Object>();
        String message = ObjectUtils.isEmpty(patient) ? "Record Not Saved" : "One Record Saved";
        
        res.put("message", message);
        res.put("data", patient);
        res.put("success", true);
        return res;
    }

    @PutMapping("/{patientNo}")
    public Map<String, Object> update(@PathVariable("patientNo") Integer patientNo, @RequestBody Patient patient) {
        patient = service.update(patientNo, patient);
        Map<String, Object> res = new HashMap<String, Object>();
        String message = ObjectUtils.isEmpty(patient) ? "Record Not Updated" : "One Record Updated";
        
        res.put("message", message);
        res.put("success", true);
        res.put("data", patient);
        return res;
    }

    @DeleteMapping("/{patientNo}")
    public Map<String, Object> delete(@PathVariable("patientNo") Integer patientNo, @RequestBody Patient patient) {
        patient = service.delete(patientNo);
        Map<String, Object> res = new HashMap<String, Object>();
        String message = ObjectUtils.isEmpty(patient) ? "Record Unable to Delete" : "One Record Deleted";
        
        res.put("message", message);
        res.put("success", true);
        res.put("data", patient);
        return res;
    }

}
