package com.chairmo.model;

import com.chairmo.util.AgeCalculatorListener;
import com.chairmo.util.ValidationListener;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@EntityListeners({ValidationListener.class, AgeCalculatorListener.class})
public class Author implements ObjectModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Version
    private Integer version;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dob;

    @Transient
    private int age;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author", orphanRemoval = true)
    private List<Book> bookList = new ArrayList<>();

    @OneToOne
    private User user;

    public void addBook(Book book){
        bookList.add(book);
        book.setAuthor(this);
    }
    public void removeBook(Book book){
        book.setAuthor(null);
        this.bookList.remove(book);
    }
}
