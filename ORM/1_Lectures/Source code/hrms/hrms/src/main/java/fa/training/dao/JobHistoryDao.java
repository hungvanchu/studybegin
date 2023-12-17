package fa.training.dao;

import fa.training.entities.JobHistory;

public interface JobHistoryDao {
    boolean save(JobHistory jobHistory) throws Exception;
}
