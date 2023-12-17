package fa.training.dao;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fa.training.entities.Employees;
import fa.training.entities.Projects;

class ProjectDaoTest {
    static ProjectDao projectDao;
    
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        projectDao = new ProjectDaoImpl();
    }
    
    @Test
    void testSave() throws Exception {
        Employees employee = new Employees("Nguyen", "Hanh Phuc",
                "phucnh@fsoft.com.vn", "0986666666", LocalDate.of(2018, 10, 1),
                3000, 1.1);
        
        Projects project = new Projects("Healcare",
                LocalDate.of(2020, 2, 1),
                "Fsoft Academey It Fundamental Training Program",
                LocalDate.of(2021, 12, 31));
        
        Set<Employees> employees = new HashSet<>();
        employees.add(employee);
        
        Set<Projects> projects = new HashSet<>();
        projects.add(project);
        
        project.setEmployees(employees);
        employee.setProjects(projects);
        
        assertTrue(projectDao.save(project));
    }
    
    @Test
    void testSearching() throws Exception {
       System.out.println(projectDao.searching(LocalDate.of(2020, 1, 1)));
        
    }
    
}
