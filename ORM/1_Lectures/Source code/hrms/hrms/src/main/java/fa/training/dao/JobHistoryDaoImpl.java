package fa.training.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.entities.JobHistory;
import fa.training.utils.HibernateUtils;

public class JobHistoryDaoImpl implements JobHistoryDao {
    
    @Override
    public boolean save(JobHistory jobHistory) throws Exception {
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Serializable result = session.save(jobHistory);
            transaction.commit();
            
            return (result != null);
            
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
}
