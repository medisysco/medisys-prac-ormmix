package my.com.medisys.prac.ormmix.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.com.medisys.prac.ormmix.entity.MaritalStatus;
import my.com.medisys.prac.ormmix.mapper.MaritalStatusMapper;
import my.com.medisys.prac.ormmix.repository.MaritalStatusRepository;

/**
 * @author    Medisys<devs@medisys.com.my>
 * @version   0.0.00.GA
 * @since     0.0.00.GA
 */
@Service
public class MaritalStatusServiceImpl implements MaritalStatusService{

    @SuppressWarnings("unused")
    private static final Logger log = LoggerFactory.getLogger(MaritalStatusServiceImpl.class);

    @Autowired
    MaritalStatusRepository repo;
    
    @Autowired
    MaritalStatusMapper mapper;

    @Override
    public List<MaritalStatus> findAll(){
        return repo.findAll();
    }

    @Override
    public List<MaritalStatus> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public MaritalStatus findByMaritalStatusCode(String maritalStatusCode){
        return repo.findByMaritalStatusCode(maritalStatusCode);
    }

    @Override
    public MaritalStatus selectByMaritalStatusCode(String maritalStatusCode) {
        return mapper.selectByMaritalStatusCode(maritalStatusCode);
    }

}
