package fa.training.entities2;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "fa.training.entities2.PublisherBook")
@Table(name = "Publisher_Book", schema = "book2")
public class PublisherBook implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    
    private String format;
    
    public PublisherBook() {
        
    }
    
    public PublisherBook(Publisher publisher, Book book, String format) {
        super();
        this.publisher = publisher;
        this.book = book;
        this.format = format;
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((book == null) ? 0 : book.hashCode());
        result = prime * result + ((format == null) ? 0 : format.hashCode());
        result = prime * result
                + ((publisher == null) ? 0 : publisher.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PublisherBook other = (PublisherBook) obj;
        if (book == null) {
            if (other.book != null)
                return false;
        } else if (!book.equals(other.book))
            return false;
        if (format == null) {
            if (other.format != null)
                return false;
        } else if (!format.equals(other.format))
            return false;
        if (publisher == null) {
            if (other.publisher != null)
                return false;
        } else if (!publisher.equals(other.publisher))
            return false;
        return true;
    }
    
}
