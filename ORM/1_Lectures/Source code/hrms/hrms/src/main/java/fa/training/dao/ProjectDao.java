package fa.training.dao;

import java.time.LocalDate;
import java.util.List;

import fa.training.entities.Projects;

public interface ProjectDao {
    
    /**
     * The method to save a new project into db.
     * 
     * @param job
     *            the new project object.
     * @return true if success otherwise return false.
     * @throws Exception
     */
    boolean save(Projects project);
    
    /**
     * The method to save a new project into db.
     * 
     * @param job
     *            the new project object.
     * @return true if success otherwise return false.
     * @throws Exception
     */
    List<Projects> searching(LocalDate startDate) throws Exception;
    /**
     * The method to save a new project into db.
     * 
     * @param job
     *            the new project object.
     * @return true if success otherwise return false.
     * @throws Exception
     */
    List<Projects> findAll();
    
    /**
     * The method to save a new project into db.
     * 
     * @param job
     *            the new project object.
     * @return true if success otherwise return false.
     * @throws Exception
     */
    List<Projects> paging(int pageNumber, int pageSize);
}
