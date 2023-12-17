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

@Entity(name="fa.training.entities2.Book")
@Table(name = "Book", schema = "book2")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;
    
    @Column(unique = true)
    private String title;
    
    private int year;
    
    @Column(length = 10)
    private String version;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
    private Set<PublisherBook> publisherBook;
    
    public Book() {
        
    }
    
    public Book(int bookId) {
        super();
        this.bookId = bookId;
    }
    
    public Book(String title, int year, String version) {
        super();
        this.title = title;
        this.year = year;
        this.version = version;
    }
    
    public Book(int bookId, String title, int year, String version) {
        super();
        this.bookId = bookId;
        this.title = title;
        this.year = year;
        this.version = version;
    }
    
    public int getBookId() {
        return bookId;
    }
    
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public int getYear() {
        return year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    public String getVersion() {
        return version;
    }
    
    public void setVersion(String version) {
        this.version = version;
    }
    
    public Set<PublisherBook> getPublisherBook() {
        return publisherBook;
    }
    
    public void setPublisherBook(Set<PublisherBook> publisherBook) {
        this.publisherBook = publisherBook;
    }
    
}
