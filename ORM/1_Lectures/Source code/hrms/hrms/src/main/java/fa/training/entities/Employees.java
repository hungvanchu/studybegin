package fa.training.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Employees", schema = "dbo", indexes = {
        @Index(columnList = "first_name, last_name", name = "IDX_EMP_NAME") }) //
@NamedNativeQueries({
        @NamedNativeQuery(name = "FIND_EMP_BY_JOB", query = "SELECT e.* "
                + "FROM dbo.Employees e JOIN dbo.Jobs j ON e.job_id = j.job_id "
                + "AND j.job_id LIKE :jobTitle", resultClass = Employees.class),
        @NamedNativeQuery(name = "FIND_ALL", query = "SELECT * FROM dbo.Employees", resultClass = Employees.class),
        @NamedNativeQuery(name = "COUNT_EMP", query = "SELECT AVG(e.salary) FROM dbo.Employees e WHERE e.job_id = :jobId") })
public class Employees {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;
    
    @Column(name = "first_name", length = 255, nullable = false)
    private String first_name;
    
    @Column(name = "last_name", length = 255, nullable = false)
    private String last_name;
    
    @Column(name = "email", length = 255, unique = true)
    private String email;
    
    @Column(name = "phone_number", length = 255, unique = true)
    private String phoneNumber;
    
    @Column(name = "hire_date")
    private LocalDate hireDate;
    
    private double salary;
    
    @Column(name = "commission_pct")
    private double commissionPct;
    
    @ManyToOne
    @JoinColumn(name = "job_id", referencedColumnName = "job_id")
    private Jobs job;
    
    @ManyToOne
    @JoinColumn(name = "dept_id", referencedColumnName = "dept_id")
    private Departments department;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "Employee_Project", schema = "dbo", joinColumns = {
            @JoinColumn(referencedColumnName = "employee_id") }, inverseJoinColumns = {
                    @JoinColumn(referencedColumnName = "project_id") })
    private Set<Projects> projects;
    
    @OneToMany(mappedBy = "id.employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<JobHistory> jobHistory;
    
    public Employees() {
        
    }
    
    public Employees(String first_name, String last_name, String email,
            String phoneNumber, LocalDate hireDate, double salary,
            double commissionPct) {
        super();
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.salary = salary;
        this.commissionPct = commissionPct;
    }
    
    public Employees(int employeeId, String first_name, String last_name,
            String email, String phoneNumber, LocalDate hireDate, double salary,
            double commissionPct) {
        super();
        this.employeeId = employeeId;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.salary = salary;
        this.commissionPct = commissionPct;
    }
    
    // public Employees(int employeeId, String first_name, String last_name,
    // String email, String phoneNumber, LocalDate hireDate, double salary,
    // double commissionPct, Jobs job) {
    // super();
    // this.employeeId = employeeId;
    // this.first_name = first_name;
    // this.last_name = last_name;
    // this.email = email;
    // this.phoneNumber = phoneNumber;
    // this.hireDate = hireDate;
    // this.salary = salary;
    // this.commissionPct = commissionPct;
    // this.job = job;
    // }
    
    public Employees(int employeeId) {
        super();
        this.employeeId = employeeId;
    }
    
    public int getEmployeeId() {
        return employeeId;
    }
    
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    
    public String getFirst_name() {
        return first_name;
    }
    
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    
    public String getLast_name() {
        return last_name;
    }
    
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public LocalDate getHireDate() {
        return hireDate;
    }
    
    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public double getCommissionPct() {
        return commissionPct;
    }
    
    public void setCommissionPct(double commissionPct) {
        this.commissionPct = commissionPct;
    }
    
    public Jobs getJob() {
        return job;
    }
    
    public void setJob(Jobs job) {
        this.job = job;
    }
    
    public Set<Projects> getProjects() {
        return projects;
    }
    
    public void setProjects(Set<Projects> projects) {
        this.projects = projects;
    }
    
    public Set<JobHistory> getJobHistory() {
        return jobHistory;
    }
    
    public void setJobHistory(Set<JobHistory> jobHistory) {
        this.jobHistory = jobHistory;
    }
    
    public Departments getDepartment() {
        return department;
    }
    
    public void setDepartment(Departments department) {
        this.department = department;
    }
    
    @Override
    public String toString() {
        return "Employees [employeeId=" + employeeId + ", first_name="
                + first_name + ", last_name=" + last_name + ", email=" + email
                + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate
                + ", salary=" + salary + ", commissionPct=" + commissionPct
                + "]";
    }
    
}
