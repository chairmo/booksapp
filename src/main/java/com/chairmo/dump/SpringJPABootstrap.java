package com.chairmo.dump;

import com.chairmo.model.Author;
import com.chairmo.model.Book;
import com.chairmo.model.User;
import com.chairmo.service.AuthorService;
import com.chairmo.service.BookService;
import com.chairmo.service.UserService;
import com.chairmo.util.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorService authorService;
    @Autowired
    private void setUserService(AuthorService authorService){
        this.authorService = authorService;
    }

    private BookService bookService;
    @Autowired
    private void setBookService(BookService bookService){
        this.bookService =bookService;
    }

    private UserService userService;
    @Autowired
    private void setAuthorService(UserService userService){
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
     //   loadUsers();
     //   loadAuthors();
     //   loadBooks();
    }

    private void loadBooks(){
        Book book = new Book();
        book.setNumOfPages(23);
        book.setIsbn("23-ey-ui-10");
        book.setTitle("java books");
        book.setLanguage(Language.WAJA);
        book.setUnitCost(38f);
        book.setImageUrl("http://images");
        bookService.saveOrUpdate(book);

        Book book1 = new Book();
        book1.setNumOfPages(33);
        book1.setIsbn("33-ey-ui-10");
        book1.setTitle("new java books");
        book1.setLanguage(Language.ENGLISH);
        book1.setUnitCost(48f);
        book1.setImageUrl("http://images/books");
        bookService.saveOrUpdate(book1);

        Book book2 = new Book();
        book2.setNumOfPages(63);
        book2.setIsbn("43-eyes-ui-10");
        book2.setTitle("java books are awesome");
        book2.setLanguage(Language.HAUSA);
        book2.setUnitCost(48f);
        book2.setImageUrl("http://images/hausa");
        bookService.saveOrUpdate(book2);

        Book book3 = new Book();
        book3.setNumOfPages(53);
        book3.setIsbn("3356-ey-ui-10");
        book3.setTitle("new to all java books");
        book3.setLanguage(Language.IGBO);
        book3.setUnitCost(88f);
        book3.setImageUrl("http://images/igbo");
        bookService.saveOrUpdate(book3);
    }
    private void loadAuthors(){
        Author author = new Author();
        author.setEmail("jay@gmail.com");
        author.setFirstName("James");
        author.setLastName("Jatau");
        author.setDob(LocalDate.of(1990,12,18));
        authorService.saveOrUpdate(author);

        Author author1 = new Author();
        author1.setEmail("joe@gmail.com");
        author1.setFirstName("Josef");
        author1.setLastName("Jane");
        author1.setDob(LocalDate.of(1998,10,28));
        authorService.saveOrUpdate(author1);
    }
    private void loadUsers(){

        Book book = new Book();
        book.setNumOfPages(23);
        book.setIsbn("23-ey-ui-10");
        book.setTitle("java books");
        book.setLanguage(Language.WAJA);
        book.setUnitCost(38f);
        book.setImageUrl("http://images");


        Book book1 = new Book();
        book1.setNumOfPages(33);
        book1.setIsbn("33-ey-ui-10");
        book1.setTitle("new java books");
        book1.setLanguage(Language.ENGLISH);
        book1.setUnitCost(48f);
        book1.setImageUrl("http://images/books");


        Book book2 = new Book();
        book2.setNumOfPages(63);
        book2.setIsbn("43-eyes-ui-10");
        book2.setTitle("java books are awesome");
        book2.setLanguage(Language.HAUSA);
        book2.setUnitCost(48f);
        book2.setImageUrl("http://images/hausa");


        Book book3 = new Book();
        book3.setNumOfPages(53);
        book3.setIsbn("3356-ey-ui-10");
        book3.setTitle("new to all java books");
        book3.setLanguage(Language.IGBO);
        book3.setUnitCost(88f);
        book3.setImageUrl("http://images/igbo");


        Author author = new Author();
        author.setEmail("jay@gmail.com");
        author.setFirstName("James");
        author.setLastName("Jatau");
        author.setDob(LocalDate.of(1990,12,18));
        author.addBook(book);
        author.addBook(book1);


        Author author1 = new Author();
        author1.setEmail("joe@gmail.com");
        author1.setFirstName("Josef");
        author1.setLastName("Jane");
        author1.setDob(LocalDate.of(1998,10,28));
        author1.addBook(book2);
        author1.addBook(book3);


        User user = new User();
        user.setUsername("jayboi");
        user.setPassword("jayjay");
        user.setAuthor(author);
        userService.saveOrUpdate(user);

        User user1 = new User();
        user1.setUsername("jayboi");
        user1.setPassword("jayjay");
        user.setAuthor(author1);
        userService.saveOrUpdate(user1);
    }

}
