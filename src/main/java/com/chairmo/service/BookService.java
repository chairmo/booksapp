package com.chairmo.service;

import com.chairmo.exception.BookNotFoundException;
import com.chairmo.model.Book;
import com.chairmo.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface BookService extends CRUDService<Book> {

   /* private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> listBooks() {
        return  bookRepository.findAll();
    }

    public Page<Book> listAllBooksWithPriceOver(Float amount, Pageable pageable) {
        return bookRepository.listAllBooksWithPriceOver(amount, pageable);
    }

    public Book findBooks(int id) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (!optionalBook.isPresent()) {
            throw new BookNotFoundException("book not found");
        }
        return optionalBook.get();
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Book book, int id) {
        return bookRepository.findById(id).map(employee -> {
            employee.setImageUrl(book.getImageUrl());
            employee.setDescription(book.getDescription());
            employee.setUnitCost(book.getUnitCost());
            employee.setLanguage(book.getLanguage());
            employee.setTitle(book.getTitle());
            employee.setIsbn(book.getIsbn());
            employee.setNumOfPages(book.getNumOfPages());
            return bookRepository.save(employee);
        })
                .orElseGet(() -> {
                    book.setId(id);
                    return bookRepository.save(book);
                });
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }*/
}
