/**
 * 
 */
package fa.training.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fa.training.entities.JobDetails;
import fa.training.entities.Jobs;

/**
 * @author DieuNT1
 *
 */
class JobDetailDaoTest {
    static JobDetailDao jobDetailDao;
    /**
     * @throws java.lang.Exception
     */
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        jobDetailDao = new JobDetailDaoImpl();
    }
    
    @Test
    void test() throws Exception {
        Jobs job = new Jobs("J01", "Java Dev1", 1000, 2000);
        assertTrue(jobDetailDao.save(new JobDetails("Java Developer Level 1", LocalDate.of(2020, 9, 1), job)));
    }
    
}
