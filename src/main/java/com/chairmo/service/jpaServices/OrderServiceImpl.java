package com.chairmo.service.jpaServices;

import com.chairmo.model.Order;
import com.chairmo.service.OrderService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class OrderServiceImpl extends AbstractJpaDaoService implements OrderService {

    @Override
    public List<Order> listAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT o FROM Order o", Order.class).getResultList();
    }

    @Override
    public Order getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Order.class, id);
    }

    @Override
    public Order saveOrUpdate(Order objectModel) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Order order = em.merge(objectModel);
        em.getTransaction().commit();
        return order;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Order.class, id));
        em.getTransaction().commit();
    }
}
