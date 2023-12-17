package fa.training.dao;

import fa.training.entities.JobDetails;

public interface JobDetailDao {
    /**
     * The method to save a JobDetail into DB.
     * @param jobDetail a JobDetails object.
     * @return return true if saving success, otherwise, return false.
     * @throws Exception 
     */
    boolean save(JobDetails jobDetail) throws Exception;
}
