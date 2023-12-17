package fa.training.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @GenericGenerator(parameters = {
    // @Parameter(name = "property", value = "user") }, strategy = "foreign",
    // name = "foreigngen")
    @Column(name = "USER_DETAIL_ID")
    private long userDetailId;
    
    @Column(name = "FIRST_NAME")
    private String firstName;
    
    @Column(name = "LAST_NAME")
    private String lastName;
    
    @Email(message = "{user.email.invalid}")
    @Column(name = "EMAIL", unique = true)
    private String email;
    
    @Column(name = "DBO")
    private LocalDate dob;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private User user;
    
    public UserDetail() {
        
    }
    
    public UserDetail(String firstName, String lastName, String email,
            LocalDate dob) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
    }
    
    public UserDetail(String firstName, String lastName, String email,
            LocalDate dob, User user) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.user = user;
    }
    
    public long getUserDetailId() {
        return userDetailId;
    }
    
    public void setUserDetailId(long userDetailId) {
        this.userDetailId = userDetailId;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public LocalDate getDob() {
        return dob;
    }
    
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
}
