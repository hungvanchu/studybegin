package fa.training.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "Publisher_Book", schema = "book")
public class PublisherBook {
    
    @EmbeddedId
    private PublisherBookId id;
    
    @ManyToOne
    @MapsId(value = "publisherId")
    private Publisher publisher;
    
    @ManyToOne
    @MapsId(value = "bookId")
    private Book book;
    
    private String format;
    
    public PublisherBookId getId() {
        return id;
    }
    
    public void setId(PublisherBookId id) {
        this.id = id;
    }
    
    public Publisher getPublisher() {
        return publisher;
    }
    
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
    
    public Book getBook() {
        return book;
    }
    
    public void setBook(Book book) {
        this.book = book;
    }
    
    public String getFormat() {
        return format;
    }
    
    public void setFormat(String format) {
        this.format = format;
    }
    
    @Override
    public String toString() {
        return "PublisherBook [id=" + id + ", format=" + format + "]";
    }
    
}
