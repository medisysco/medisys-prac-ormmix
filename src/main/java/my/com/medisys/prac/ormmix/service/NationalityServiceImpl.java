package my.com.medisys.prac.ormmix.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.com.medisys.prac.ormmix.entity.Nationality;
import my.com.medisys.prac.ormmix.mapper.NationalityMapper;
import my.com.medisys.prac.ormmix.repository.NationalityRepository;

/**
 * @author    Medisys<devs@medisys.com.my>
 * @version   0.0.00.GA
 * @since     0.0.00.GA
 */
@Service
public class NationalityServiceImpl implements NationalityService{

    @SuppressWarnings("unused")
    private static final Logger log = LoggerFactory.getLogger(NationalityServiceImpl.class);

    @Autowired
    NationalityRepository repo;
    
    @Autowired
    NationalityMapper mapper;

    public List<Nationality> findAll(){
        return repo.findAll();
    }

    @Override
    public List<Nationality> selectAll() {
        return mapper.selectAll();
    }

    public Nationality findByNationalityCode(String nationalityCode){
        return repo.findByNationalityCode(nationalityCode);
        //return repo.findOne(nationalityCode);
    }

    @Override
    public Nationality selectByNationalityCode(String nationalityCode) {
        return mapper.selectByNationalityCode(nationalityCode);
    }

}
