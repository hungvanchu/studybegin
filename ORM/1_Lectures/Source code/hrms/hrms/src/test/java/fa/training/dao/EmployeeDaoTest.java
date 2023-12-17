package fa.training.dao;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fa.training.entities.Departments;
import fa.training.entities.Employees;
import fa.training.entities.Jobs;
import fa.training.entities.Projects;

class EmployeeDaoTest {
    static EmployeeDao employeeDao;
    
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        employeeDao = new EmployeeDaoImpl();
    }
    
    @Test
    void testSave() throws Exception {
//        Jobs job = new Jobs("J01", "Java Dev1", 1000, 2000);
        
        Departments department = new Departments(1, "IT Tools");
                
        Employees employee = new Employees("Nguyen", "Van Tuan",
                "tuan@fsoft.com.vn", "0988777222", LocalDate.of(2020, 1, 1),
                1000, 1.1);
        
        employee.setDepartment(department);
        
        assertTrue(employeeDao.save(employee));
    }
    
    @Test
    void testSave2() throws Exception {
        Employees employee = new Employees("Hoang", "Van Liem",
                "Liem@fsoft.com.vn", "0988777112", LocalDate.of(1999, 1, 1),
                1000, 1.1);
        
        // Liên quan đến Project (n-n)
        Projects project = new Projects("IT Fundamental 3",
                LocalDate.of(2020, 10, 1),
                "Fsoft Academey It Fundamental Training Program",
                LocalDate.of(2020, 12, 31));
        
        Set<Employees> employees = new HashSet<>();
        employees.add(employee);
        
        Set<Projects> projects = new HashSet<>();
        projects.add(project);
        
        project.setEmployees(employees);
        employee.setProjects(projects);
        
        // Liên quan đến Job (1-n)
        Jobs job = new Jobs("J02", "Java Dev 2", 1000, 2000);
        
        employee.setJob(job);
        
        // Liên quan đến history
        assertTrue(employeeDao.save(employee));
    }
    
    @Test
    void testFindByName() {
        List<Employees> employees = employeeDao.findByName("Nguyen",
                "Minh Thanh");
        System.out.println(employees);
    }
    
    @Test
    void testFindByJob() {
        List<Employees> employees = employeeDao.findByJob("J01");
        System.out.println(employees);
    }
    
    @Test
    void testFindAll() throws Exception {
        List<Employees> employees = employeeDao.findAll();
        System.out.println(employees);
    }
    
    @Test
    void testCountEmp() throws Exception {
        System.out.println(employeeDao.countByJob("J01"));
    }
    @Test
    void testFindByDept() throws Exception {
        System.out.println(employeeDao.findEmpByDept("IT Tools", LocalDate.of(2020, 1, 1)));
    }
    
}
