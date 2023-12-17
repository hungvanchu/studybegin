package fa.training.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PublisherBookId implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Column(name = "publisher_id")
    private int publisherId;
    @Column(name = "book_id")
    private int bookId;
    
    public PublisherBookId() {
        
    }
    
    public PublisherBookId(int publisherId, int bookId) {
        super();
        this.publisherId = publisherId;
        this.bookId = bookId;
    }
    
    public int getPublisherId() {
        return publisherId;
    }
    
    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }
    
    public int getBookId() {
        return bookId;
    }
    
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + bookId;
        result = prime * result + publisherId;
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
        PublisherBookId other = (PublisherBookId) obj;
        if (bookId != other.bookId)
            return false;
        if (publisherId != other.publisherId)
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "PublisherBookId [publisherId=" + publisherId + ", bookId="
                + bookId + "]";
    }
    
}
