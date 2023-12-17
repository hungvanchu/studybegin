package fa.training.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.entities.JobDetails;
import fa.training.utils.HibernateUtils;

public class JobDetailDaoImpl implements JobDetailDao {
    
    @Override
    public boolean save(JobDetails jobDetail) throws Exception {
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Serializable result = session.save(jobDetail);
            transaction.commit();
            
            return (result != null);
            
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
}
