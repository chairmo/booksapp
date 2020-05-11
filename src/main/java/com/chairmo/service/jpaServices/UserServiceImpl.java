package com.chairmo.service.jpaServices;

import com.chairmo.model.User;
import com.chairmo.service.UserService;
import com.chairmo.service.securityService.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class UserServiceImpl extends AbstractJpaDaoService implements UserService {

    private EncryptionService encryptionService;

    @Autowired
    private void setEncryptionService(EncryptionService encryptionService){
        this.encryptionService = encryptionService;
    }

    @Override
    public List<User> listAll() {
         EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public User getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(User.class, id);
    }

    @Override
    public User saveOrUpdate(User userModel) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        if (userModel.getPassword() != null){
            userModel.setEncryptedPassword(encryptionService.encryptString(userModel.getPassword()));
        }
        User user = em.merge(userModel);
        em.getTransaction().commit();

        return user;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(User.class, id));
        em.getTransaction().commit();
    }
}
