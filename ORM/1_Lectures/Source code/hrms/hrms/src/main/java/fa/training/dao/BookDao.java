package fa.training.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.entities.Book;
import fa.training.utils.HibernateUtils;

public class BookDao {
    
    public boolean save(fa.training.entities2.Book book) throws Exception {
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            Serializable result = session.save(book);
            
            transaction.commit();
            
            return (result != null);
            
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    public boolean save(Book book) throws Exception {
        Session session = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            
            Integer id = (Integer) session.save(book);
            
            System.out.println(
                    "1. Book save called without transaction, id=" + id);
            
            return (id != null);
            
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
