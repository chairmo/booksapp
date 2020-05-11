package com.chairmo.service.jpaServices;

import com.chairmo.model.Customer;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Profile("Dao")
public class CustomerServiceImpl extends AbstractJpaDaoService implements com.chairmo.service.CustomerService {
    @Override
    public List<Customer> listAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
    }

    @Override
    public Customer getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Customer.class, id);
    }

    @Override
    public Customer saveOrUpdate(Customer objectModel) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Customer customer = em.merge(objectModel);
        em.getTransaction().commit();
        return customer;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Customer.class, id));
        em.getTransaction().commit();
    }
}
