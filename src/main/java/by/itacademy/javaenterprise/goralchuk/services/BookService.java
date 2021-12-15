package by.itacademy.javaenterprise.goralchuk.services;

import by.itacademy.javaenterprise.goralchuk.dao.BaseDao;
import by.itacademy.javaenterprise.goralchuk.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j(topic = "/ BOOK_SERVICE")
@Service
@Component("bookService")
public class BookService {
    @Autowired
    private BaseDao<Book> bookBaseDao;

    public void addBookToDataBase(Book book) {
        log.debug("Service added entity");
        bookBaseDao.add(book);
    }

    public List<Book> findAllBookFromDatabase() {
        log.debug("Service found all entities");
        return bookBaseDao.findAll();
    }

    public List<Book> findAllBookFromDatabaseByLanguage(String lang) {
        log.debug("Service found all entities by language");
        return List.copyOf(bookBaseDao.findAll()
                .stream()
                .filter(el -> el.getLanguage().equals(lang))
                .collect(Collectors.toList()));
    }

    public void removeBookFromDataBaseByAuthor(String author) {
        List<Book> list = bookBaseDao.findAll();
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAuthor().equals(author)) {
                bookBaseDao.remove(i);
                count++;
            }
        }
        log.debug("Service removed {} entities by author: {}", count, author);
    }

    public void removeFromDataBaseById(int id) {
        bookBaseDao.remove(id);
    }

    public List<Book> findFilterBookByAllParameters(String author, String nameBook, String lang){
        log.debug("Service filtered");
        return List.copyOf(bookBaseDao.findAll()
                .stream()
                .filter(el -> el.getAuthor().equals(author)
                        && el.getNameBook().equals(nameBook)
                        && el.getLanguage().equals(lang))
                .collect(Collectors.toList()));
    }
    public void getThrowException(){
        log.error("IllegalArgumentException");
        throw new IllegalArgumentException();
    }

}
