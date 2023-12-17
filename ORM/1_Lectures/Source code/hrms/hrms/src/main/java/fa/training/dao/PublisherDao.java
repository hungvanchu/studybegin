package fa.training.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fa.training.entities2.Publisher;
import fa.training.utils.HibernateUtils;

public class PublisherDao {
    
    public boolean save(Publisher publisher) throws Exception {
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            Serializable result = session.save(publisher);
            
            transaction.commit();
            
            return (result != null);
            
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    public List<Object[]> findPublisherBook() {
        Session session = null;
        
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            
            String joinQuery = "FROM Publisher p INNER JOIN p.publisherBook pb";
            String joinQuery2 = "FROM Publisher p INNER JOIN p.publisherBook pb "
                    + "ON p.publisherId = pb.publisher.publisherId "
                    + "INNER JOIN Book b "
                    + "ON b.bookId = pb.book.bookId";
            String joinQuery3 = "FROM Publisher p JOIN p.publisherBook pb "
                    + "JOIN pb.book b ";
            
            Query quey = session.createQuery(joinQuery3);
            // + "INNER JOIN Book b");
            
            return quey.list();
            
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
