package my.com.medisys.prac.ormmix.service;

import java.util.List;

import my.com.medisys.prac.ormmix.entity.Gender;

/**
 * @author    Medisys<devs@medisys.com.my>
 * @version   0.0.00.GA
 * @since     0.0.00.GA
 */
public interface GenderService {
    List<Gender> findAll();
    List<Gender> selectAll();
    Gender getByGenderCode(String genderCode);
    Gender selectByGenderCode(String genderCode);
}
