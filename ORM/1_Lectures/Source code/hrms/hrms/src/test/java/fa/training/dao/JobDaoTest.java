package fa.training.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fa.training.entities.Employees;
import fa.training.entities.JobDetails;
import fa.training.entities.Jobs;

class JobDaoTest {
    static JobDao jobDao;
    
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        jobDao = new JobDaoImpl();
    }
    
    @Test
    void testSave1() throws Exception {
        
        JobDetails jobDetail = new JobDetails("Java Developer Level 1",
                LocalDate.of(2020, 9, 1));
        Jobs job = new Jobs("J01", "Java Dev1", 1000, 2000);
        
        job.setJobDetail(jobDetail);
        jobDetail.setJob(job);
        
        assertEquals(true, jobDao.save(job));
    }
    
    @Test
    void testSave2() throws Exception {
        Jobs job = new Jobs("J02", "Java Dev2", 1200, 2200);
        assertEquals(true, jobDao.save(job));
    }
    
    @Test
    void testSave3() throws Exception {
        Jobs job = new Jobs("J03", "Java Dev3", 1400, 3200);
        
        assertEquals(true, jobDao.save(job));
    }
    
    @Test
    void testUpdate() throws Exception {
        Jobs job = new Jobs("J03", "Java Dev3", 1400, 3200);
        
        assertEquals(true, jobDao.update(job));
    }
    
    @Test
    void testSave4() throws Exception {
        System.out.println(jobDao.findById("J01"));
    }
    
    @Test
    void testFindAll() throws Exception {
        List<Object[]> jobs = jobDao.findAll();
        
        for (Object[] object : jobs) {
            Jobs job = (Jobs) object[0];
            System.out.println(job);
            
            for (Employees employee : job.getEmployees()) {
                System.out.println(employee);
            }
        }
    }
    
    @Test
    void testCountEmploye() throws Exception {
        List<Object[]> objects = jobDao.countEmploye();
        
        for (Object[] object : objects) {
            System.out.println((String) object[0] + ": " + (Long) object[1]);
            
        }
    }
}
