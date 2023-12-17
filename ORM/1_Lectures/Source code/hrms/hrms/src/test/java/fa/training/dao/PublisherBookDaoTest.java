package fa.training.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fa.training.entities2.Book;
import fa.training.entities2.Publisher;
import fa.training.entities2.PublisherBook;
import fa.training.entities.PublisherBookId;

class PublisherBookDaoTest {
    static PublisherBookDao publisherBookDao;
    static BookDao bookDao;
    static PublisherDao publisherDao;
    
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        publisherBookDao = new PublisherBookDao();
        bookDao = new BookDao();
        publisherDao = new PublisherDao();
    }
    
    /**
     * Test for package entities
     * 
     * @throws Exception
     */
    @Test
    void testSave() throws Exception {
        // Book book = new Book(1, "Java SE", 2020, "1.0");
        // assertTrue(bookDao.save(book));
        //
        // Publisher publisher = new Publisher(1, "NXB GD", "0979867234");
        // assertTrue(publisherDao.save(publisher));
        //
        // PublisherBookId id = new PublisherBookId(1, 1);
        //
        // PublisherBook publisherBook = new PublisherBook();
        // publisherBook.setId(id);
        // publisherBook.setFormat("ABC");
        // publisherBook.setBook(book);
        // publisherBook.setPublisher(publisher);
        //
        // assertTrue(publisherBookDao.save(publisherBook));
    }
    
    /**
     * Test for package entities2
     * 
     * @throws Exception
     */
    @Test
    void testSave2() throws Exception {
        Book book = new Book(1, "Java SE", 2020, "1.0");
        assertTrue(bookDao.save(book));
        
        Publisher publisher = new Publisher(1, "NXB GD", "0979867234");
        assertTrue(publisherDao.save(publisher));
        
        PublisherBook publisherBook = new PublisherBook(publisher, book, "ABC");
        
        assertTrue(publisherBookDao.save(publisherBook));
    }
    
    @Test
    void testFindPublisherBook() {
        List<Object[]> objects = publisherDao.findPublisherBook();
        
        for (Object[] object : objects) {
            System.out.println((fa.training.entities.Publisher) object[0]);
            
            System.out.println((fa.training.entities.PublisherBook) object[1]);
            System.out.println((fa.training.entities.Book) object[2]);
        }
        
    }
    
}
