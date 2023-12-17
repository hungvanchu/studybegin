package fa.training.dao;

import java.time.LocalDate;
import java.util.List;

import fa.training.entities.Employees;

public interface EmployeeDao {
    
    /**
     * The method to save a new employee into db.
     * 
     * @param job
     *            the new employee object.
     * @return true if success otherwise return false.
     * @throws Exception
     */
    boolean save(Employees employee) throws Exception;
    
    /**
     * The method to search by firstName and lastName of Employees.
     * 
     * @param firstName
     * @param lastName
     * @return
     */
    List<Employees> findByName(String firstName, String lastName);
    
    /**
     * The method to get all of the employees by job title.
     * 
     * @param jobTitle
     * @return
     */
    List<Employees> findByJob(String jobTile);
    /**
     * The method to count of the employees by job id.
     * 
     * @param jobTitle
     * @return
     */
    double countByJob(String jobId);
    /**
     * The method to get all of the employees by job title.
     * 
     * @param jobTitle
     * @return
     */
    List<Employees> findAll() throws Exception;
    
    List<Employees> findEmpByDept(String deptName, LocalDate hiredate); 
}
