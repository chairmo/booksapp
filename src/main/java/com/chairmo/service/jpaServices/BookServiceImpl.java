package com.chairmo.service.jpaServices;

import com.chairmo.model.Book;
import com.chairmo.service.BookService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class BookServiceImpl extends AbstractJpaDaoService implements BookService {

    @Override
    public List<Book> listAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    @Override
    public Book getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Book.class, id);
    }

    @Override
    public Book saveOrUpdate(Book objectModel) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Book book = em.merge(objectModel);
        em.getTransaction().commit();
        return book;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Book.class, id));
        em.getTransaction().commit();
    }
}
