package com.chairmo.service.jpaServices;

import com.chairmo.model.Product;
import com.chairmo.service.ProductService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class ProductServiceImpl extends AbstractJpaDaoService implements ProductService {
    @Override
    public List<Product> listAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    @Override
    public Product getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Product.class, id);
    }

    @Override
    public Product saveOrUpdate(Product objectModel) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Product product = em.merge(objectModel);
        em.getTransaction().commit();
        return product;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Product.class, id));
        em.getTransaction().commit();
    }
}
