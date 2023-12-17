package fa.training.dao;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fa.training.entities.Projects;
import fa.training.utils.HibernateUtils;

public class ProjectDaoImpl implements ProjectDao {
    
    @Override
    public boolean save(Projects project) {
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Serializable result = session.save(project);
            transaction.commit();
            
            return (result != null);
            
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    @Override
    public List<Projects> findAll() {
        Session session = null;
        
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            
            String hql = "FROM Project p ";
            
            
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }
    
    @Override
    public List<Projects> paging(int pageNumber, int pageSize) {
        Session session = null;
        
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            
            String hql = "FROM Project WHERE startDate >= :startDate";
            
            return null;
            
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    @Override
    public List<Projects> searching(LocalDate startDate) throws Exception {
        Session session = null;
        
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            
            String hql = "FROM Projects WHERE startDate >= :startDate "
                          + "ORDER BY completedOn DESC";
            
            Query<Projects> query = session.createQuery(hql);
            
            query.setParameter("startDate", startDate);
            
            List<Projects> listResult = query.list();
            
            return listResult;
            
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
}
