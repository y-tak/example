import entity.Book;
import javafx.scene.chart.PieChart;
import repository.BookRepository;
import specification.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class TstBook {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("OrmExample");
        EntityManager entityManager = factory.createEntityManager();

        BookRepository bookRepository = new BookRepository(entityManager);

//        // добавление книг в бд
//        for (int i = 1; i < 6; i++) {
//            Book book = new Book();
//            book.setTitle("Книга2018: " + i);
//            book.setPageCount(i);
//
//            Calendar d=new GregorianCalendar();
//
//            book.setAddDate(d);
//            bookRepository.add(book);
//
//
//        }

        // получить книгу с id = 1
        Book bookById = bookRepository.getByPk(2);
        System.out.println(bookById.getTitle());

        bookById.setTitle("Новое название");
        bookRepository.update(bookById);

       /// удаление книги из бд
     //   bookRepository.delete(1);

        List<Book> books = bookRepository.getAll();
        for (Book book: books){
            System.out.println(book.getTitle());
        }

        List<Book> booksByTitle  = bookRepository.getBySpecification(new BookByTitle("Книга 3"));
        for (Book book: booksByTitle){
            System.out.println(book.getTitle());
        }

        Calendar dateC1=new GregorianCalendar();
        Calendar dateC2=new GregorianCalendar();
        int thisYear=dateC1.get(1);
        System.out.println("thisYear = " + thisYear);

        dateC1.set( thisYear,1,1);
///-------------домашка---------------------
        System.out.println("всего добавилив этом году = " );
        List<Book> booksByDate  = bookRepository.getBySpecification(new BookByDate(dateC1,dateC2));
        for (Book book: booksByDate){
            System.out.println(book.getTitle());
        }

        System.out.println("число чтраниц больше  либо равно 4 " );
        List<Book> booksMorPage  = bookRepository.getBySpecification(new BookPageMoreValue(4));
        for (Book book: booksMorPage){
            System.out.println(book.getTitle());
        }
        ///-------------домашка
        System.out.println("двойной отбор по названию и числу страниц  либо равно 4 " );
       Specification<Book> multiSpec =
               new TwoSpecification<Book>(new BookByTitle("Книга 4"), new BookPageMoreValue(4));
        List<Book> bookList = bookRepository.getBySpecification(multiSpec);
        for (Book book: bookList){
            System.out.println(book.getTitle());
        }
        entityManager.close();
        factory.close();
    }
}