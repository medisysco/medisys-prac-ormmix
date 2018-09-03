package my.com.medisys.prac.ormmix.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import my.com.medisys.prac.ormmix.entity.Gender;

/**
 * @author    Medisys<devs@medisys.com.my>
 * @version   0.0.00.GA
 * @since     0.0.00.GA
 */
@Repository
@Transactional(readOnly = true)
public class GenderRepositoryImpl implements GenderRepositoryCustom {

    @SuppressWarnings("unused")
    private static final Logger log = LoggerFactory.getLogger(GenderRepositoryImpl.class);

    @Autowired
    SessionFactory sessionFactory;

    /*@PersistenceContext
    EntityManager em;*/

    /*@Override
    @SuppressWarnings("unchecked")
    public Gender findByGenderCode(String genderCode) {
        String hql = "SELECT g FROM Gender g WHERE g.genderCode = :genderCode";
        Query qry = getSession().createQuery(hql);
        qry.setParameter("genderCode", genderCode);
        List<Gender> genders = qry.list();
        return CollectionUtils.isEmpty(genders) ? null : genders.get(0);
    }*/

    /*@Override
    public Gender findByGenderCode(String genderCode) {
        String jql = "SELECT g FROM Gender g WHERE g.genderCode = :genderCode";
        Query qry = em.createQuery(jql);
        qry.setParameter("genderCode", genderCode);
        return (Gender) qry.getSingleResult();
    }*/

    @Override
    @SuppressWarnings("unchecked")
    public Gender findByGenderCode(String genderCode) {
        Query qry = getSession().getNamedQuery("Gender.findByGenderCode");
        qry.setParameter("genderCode", genderCode);
        List<Gender> genders = qry.list();
        return CollectionUtils.isEmpty(genders) ? null : genders.get(0);
    }

    /*@Override
    public Gender findByGenderCode(String genderCode) {
        Query qry = em.createNamedQuery("Gender.findByGenderCode");
        qry.setParameter("genderCode", genderCode);
        Gender gender = null;
        try {
            gender = (Gender) qry.getSingleResult();
        }catch(NoResultException e) {
            log.warn(e.getMessage());
        }
        return gender;
    }*/

    /*@Override
    public Gender findByGenderCode(String genderCode) {
        return getSession().get(Gender.class, genderCode);
    }*/

    /*@Override
    public Gender findByGenderCode(String genderCode) {
        return em.find(Gender.class, genderCode);
    }*/

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
