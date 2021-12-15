package by.itacademy.javaenterprise.goralchuk.servises;

import by.itacademy.javaenterprise.goralchuk.dao.BaseDao;
import by.itacademy.javaenterprise.goralchuk.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BookService {
    @Autowired
    private BaseDao<Book> bookBaseDao;

    public void addBookToDataBase(Book book) {
        bookBaseDao.add(book);
    }

    public List<Book> findAllBookFromDatabase() {
        return bookBaseDao.findAll();
    }
}
