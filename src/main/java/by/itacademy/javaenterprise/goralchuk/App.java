package by.itacademy.javaenterprise.goralchuk;

import by.itacademy.javaenterprise.goralchuk.entity.Book;
import by.itacademy.javaenterprise.goralchuk.servises.BookService;
import by.itacademy.javaenterprise.goralchuk.spring.SpringConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        BookService bookService = context.getBean(BookService.class) ;
        bookService.addBookToDataBase(new Book("NameA", "AuthorA", "eng" , 200));
        bookService.addBookToDataBase(new Book("NameB", "AuthorB", "rus" , 100));
        bookService.addBookToDataBase(new Book("NameC", "AuthorC", "eng" , 50));
        log.info("ALL BOOK:\n {}", bookService.findAllBookFromDatabase());
    }
}
