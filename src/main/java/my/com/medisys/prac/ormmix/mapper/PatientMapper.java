package my.com.medisys.prac.ormmix.mapper;

import java.util.List;

import my.com.medisys.prac.ormmix.entity.Patient;

/**
 * @author    Medisys<devs@medisys.com.my>
 * @version   0.0.00.GA
 * @since     0.0.00.GA
 */
public interface PatientMapper {
    List<Patient> selectAll();
    Patient selectByPatientNo(Integer patientNo);
}
