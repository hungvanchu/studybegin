package fa.training.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fa.training.entities.Jobs;
import fa.training.utils.HibernateUtils;

public class JobDaoImpl implements JobDao {
    
    @Override
    public boolean save(Jobs job) throws Exception {
        Session session = null;
        
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            
            Serializable id = session.save(job);
            
            System.out.println(
                    "1. Job save called without transaction, id = " + id);
            
            return (id != null);
            
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    @Override
    public List<Object[]> findAll() throws Exception {
        
        Session session = null;
        
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Query query = session.createNativeQuery(
                    "SELECT j.*, e.* FROM dbo.Jobs j JOIN dbo.Employees e "
                            + "ON j.job_id = e.job_id")
                    .addEntity("j", Jobs.class).addJoin("e", "j.employees");
            
            List<Object[]> jobs = query.list();
            
            // for (Object[] object : jobs) {
            // Jobs job = (Jobs) object[0];
            // System.out.println(job);
            //
            // for (Employees employee : job.getEmployees()) {
            // System.out.println(employee);
            // }
            // }
            
            return jobs;
            
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    @Override
    public Jobs findById(String jobId) throws Exception {
        Session session = null;
        
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            
            Jobs job = session.get(Jobs.class, jobId);
            System.out.println(job.getEmployees());
            
            return job;
            
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    @Override
    public List<Jobs> findByNameAndSalary(String title, double salary)
            throws Exception {
        Session session = null;
        
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            
            Query query = session.createNativeQuery(
                    "SELECT * FROM dbo.Jobs j WHERE j.job_title LIKE :title "
                            + "AND j.min_salary <= :salary AND j.max_salary >= :salary")
                    .addEntity(Jobs.class);
            
            query.setParameter("title", "%" + title + "%");
            query.setParameter("salary", salary);
            
            return query.list();
            
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    @Override
    public List<Object[]> countEmploye() throws Exception {
        Session session = null;
        
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            
            Query query = session
                    .createQuery("SELECT e.job.jobTitle, COUNT(e.employeeId) "
                            + "FROM Employees e GROUP BY e.job.jobTitle");
            
            return query.list();
            
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    @Override
    public boolean update(Jobs job) throws Exception {
        
        Session session = null;
        
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            
            Transaction transaction = session.beginTransaction();
            
            session.update(job);
            
            transaction.commit();
            
            return true;
            
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
}
