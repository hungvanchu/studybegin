package fa.training.entities;

import java.time.LocalDate;

import javax.persistence.AssociationOverride;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Job_History", schema = "dbo")
@AssociationOverride(name="id.employee", joinColumns=@JoinColumn(name="employee_id"))
public class JobHistory {
    
    @EmbeddedId
    private JobHistoryId id;
    
    // extra fields
    @Column(name = "end_date")
    private LocalDate endDate;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    private Jobs job;
    
    @Transient
    public Employees getEmployees() {
        return getId().getEmployee();
    }
    
    public void setEmployees(Employees employee) {
        getId().setEmployee(employee);
    }
    
    public JobHistoryId getId() {
        return id;
    }
    
    public void setId(JobHistoryId id) {
        this.id = id;
    }
    
    public LocalDate getEndDate() {
        return endDate;
    }
    
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    
    public Jobs getJob() {
        return job;
    }
    
    public void setJob(Jobs job) {
        this.job = job;
    }
    
}
