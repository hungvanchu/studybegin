package fa.training.dao;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fa.training.entities.Employees;
import fa.training.entities.JobHistory;
import fa.training.entities.JobHistoryId;
import fa.training.entities.Jobs;

class JobHistoryDaoTest {
    static JobHistoryDao jhDao;
    
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        jhDao = new JobHistoryDaoImpl();
    }
    
    @Test
    void testSave() throws Exception {
        JobHistory jobHistory = new JobHistory();
        
        JobHistoryId id = new JobHistoryId();
        id.setEmployee(new Employees(1));
        id.setStartDate(LocalDate.of(2020, 1, 1));
        
        jobHistory.setId(id);
        jobHistory.setEndDate(LocalDate.of(2020, 12, 31));
        jobHistory.setJob(new Jobs("J01"));
        
        assertTrue(jhDao.save(jobHistory));
    }
    
}
