package fa.training.entities2;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="fa.training.entities2.Publisher")
@Table(name = "Publisher", schema = "book2")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private int publisherId;
    
    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String phone;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publisher")
    private Set<PublisherBook> publisherBook;
    
    public Publisher() {
        
    }
    
    public Publisher(int publisherId) {
        super();
        this.publisherId = publisherId;
    }
    
    public Publisher(int publisherId, String name, String phone) {
        super();
        this.publisherId = publisherId;
        this.name = name;
        this.phone = phone;
    }
    
    public Publisher(String name, String phone) {
        super();
        this.name = name;
        this.phone = phone;
    }
    
    public int getPublisherId() {
        return publisherId;
    }
    
    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public Set<PublisherBook> getPublisherBook() {
        return publisherBook;
    }
    
    public void setPublisherBook(Set<PublisherBook> publisherBook) {
        this.publisherBook = publisherBook;
    }
    
}
