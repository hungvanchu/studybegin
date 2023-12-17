package fa.training.dao;

import java.util.List;

import fa.training.entities.Jobs;

public interface JobDao {
    /**
     * The method to save a new job into db.
     * 
     * @param job
     *            the new job object.
     * @return true if success otherwise return false.
     * @throws Exception
     */
    boolean save(Jobs job) throws Exception;
    
    boolean update(Jobs job) throws Exception;
    
    List<Object[]> findAll() throws Exception;
    
    List<Jobs> findByNameAndSalary(String title, double salary)
            throws Exception;
    
    Jobs findById(String jobId) throws Exception;
    
    List<Object[]> countEmploye() throws Exception;
    
}