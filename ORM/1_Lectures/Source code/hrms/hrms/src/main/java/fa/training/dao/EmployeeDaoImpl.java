package fa.training.dao;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fa.training.entities.Departments;
import fa.training.entities.Employees;
import fa.training.utils.HibernateUtils;

public class EmployeeDaoImpl implements EmployeeDao {
    
    @Override
    public boolean save(Employees employee) throws Exception {
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            // transaction = session.beginTransaction();
            
            Serializable result = session.save(employee);
            //
            // transaction.commit();
            
            return (result != null);
            
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    @Override
    public List<Employees> findByName(String firstName, String lastName) {
        
        Session session = null;
        
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            
            Query<Object[]> query = session.createSQLQuery(
                    "SELECT e.*, j.* FROM dbo.Employees e JOIN dbo.Jobs j ON e.job_id = j.job_id "
                            + "WHERE e.last_name = :lastName AND e.first_name = :firstName")
                    .addEntity("e", Employees.class).addJoin("j", "e.job");
            query.setParameter("lastName", lastName);
            query.setParameter("firstName", firstName);
            
            List<Object[]> objects = query.list();
            
            for (Object[] object : objects) {
                Employees employee = (Employees) object[0];
                
                System.out.println(employee);
                System.out.println(employee.getJob());
            }
            return null;
            
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    @Override
    public List<Employees> findByJob(String jobTile) {
        Session session = null;
        
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            
            Query<Employees> query = session
                    .createNamedQuery("FIND_EMP_BY_JOB");
            
            query.setParameter("jobTitle", "%" + jobTile + "%");
            return query.list();
            
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    @Override
    public List<Employees> findAll() throws Exception {
        Session session = null;
        
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            
            // Query<Employees> query = session.createNamedQuery("FIND_ALL");
            Query query = session.createQuery("FROM Employees");
            
            query.setFirstResult(0);
            query.setMaxResults(10);
            
            return query.list();
            
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    @Override
    public double countByJob(String jobId) {
        Session session = null;
        
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            
            Query query = session.createNamedQuery("COUNT_EMP");
            query.setParameter("jobId", jobId);
            
            return (double) query.getSingleResult();
            
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    @Override
    public List<Employees> findEmpByDept(String deptName, LocalDate hiredate) {
        Session session = null;
        
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            // Using FROM and JOIN
            CriteriaQuery<Employees> criteriaQuery = builder
                    .createQuery(Employees.class);
            Root<Employees> empRoot = criteriaQuery.from(Employees.class);
            Root<Departments> deptRoot = criteriaQuery.from(Departments.class);
            criteriaQuery.select(empRoot);
            
            criteriaQuery.where(builder.equal(empRoot.get("department"),
                    deptRoot.get("deptId")));
            criteriaQuery.where(builder.and(
                    builder.equal(deptRoot.get("deptName"), deptName),
                    builder.equal(empRoot.get("hireDate"), hiredate)));
            
            Query<Employees> query = session.createQuery(criteriaQuery);
            List<Employees> list = query.getResultList();
            
            return list;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
}
