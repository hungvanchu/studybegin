package fa.training.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private long userId;
    
    @Pattern(regexp="^[A-Za-z0-9_]+$", message="{user.name.rex}")
    @Size(max = 30, min = 8, message = "{user.name.invalid}")
    @NotEmpty(message = "Please enter username")
    @Column(name = "USERNAME", nullable = false, unique = true)
    private String username;
    
    @Column(name = "PASSWORD")
    private String password;
    
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // @PrimaryKeyJoinColumn
    private UserDetail userDetail;
    
    public User() {
        
    }
    
    public User(String username, String password, UserDetail userDetail) {
        super();
        this.username = username;
        this.password = password;
        this.userDetail = userDetail;
    }
    
    public long getUserId() {
        return userId;
    }
    
    public void setUserId(long userId) {
        this.userId = userId;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public UserDetail getUserDetail() {
        return userDetail;
    }
    
    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }
    
}

