package fa.training.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.entities2.PublisherBook;
import fa.training.utils.HibernateUtils;

public class PublisherBookDao {
    public boolean save(PublisherBook publisherBook) {
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            Serializable result = session.save(publisherBook);
            
            transaction.commit();
            
            return (result != null);
            
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
