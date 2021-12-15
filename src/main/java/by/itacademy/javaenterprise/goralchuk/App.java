package by.itacademy.javaenterprise.goralchuk;

import by.itacademy.javaenterprise.goralchuk.entity.Book;
import by.itacademy.javaenterprise.goralchuk.services.BookService;
import by.itacademy.javaenterprise.goralchuk.spring.SpringConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j(topic = "/ APP_MAIN")
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.addBookToDataBase(new Book("NameA", "AuthorA", "eng", 200));
        bookService.addBookToDataBase(new Book("NameB", "AuthorB", "rus", 100));
        bookService.addBookToDataBase(new Book("NameC", "AuthorC", "eng", 50));
        bookService.addBookToDataBase(new Book("NameD", "AuthorA", "fra", 70));

        bookService.findFilterBookByAllParameters("AuthorA", "NameA", "eng");
        bookService.findAllBookFromDatabase();
        bookService.findAllBookFromDatabaseByLanguage("eng");
        bookService.removeBookFromDataBaseByAuthor("AuthorA");
        bookService.removeFromDataBaseById(100);

        try {
            bookService.getThrowException();
        } catch (Exception e) {
            log.error("Exception: {}", e.getMessage());
        }

        context.close();
    }
}
