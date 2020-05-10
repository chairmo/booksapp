package com.chairmo.service.jpaServices;

import com.chairmo.model.Author;
import com.chairmo.service.AuthorService;
import com.chairmo.service.securityService.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class AuthorServiceImpl extends AbstractJpaDaoService implements AuthorService {

    private EncryptionService encryptionService;
    @Autowired
    private void setEncryptionService(EncryptionService encryptionService){
        this.encryptionService = encryptionService;
    }

    @Override
    public List<Author> listAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT a FROM Author a", Author.class).getResultList();
    }

    @Override
    public Author getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Author.class, id);
    }

    @Override
    public Author saveOrUpdate(Author objectModel) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        if (objectModel.getUser() != null && objectModel.getUser().getPassword() != null){
            objectModel.getUser().setEncryptedPassword
                    (encryptionService.encryptString(objectModel.getUser().getPassword()));
        }
        Author author = em.merge(objectModel);
        em.getTransaction().commit();
        return author;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.remove(em.find(Author.class, id));
    }
}
