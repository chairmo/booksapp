package com.chairmo.service.jpaServices;

import com.chairmo.model.role.Role;
import com.chairmo.service.securityService.RoleService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class RoleServiceImpl extends AbstractJpaDaoService implements RoleService {
    @Override
    public List<Role> listAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT r FROM Role r", Role.class).getResultList();
    }

    @Override
    public Role getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Role.class, id);
    }

    @Override
    public Role saveOrUpdate(Role objectModel) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Role role = em.merge(objectModel);
        em.getTransaction().commit();
        return role;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Role.class, id));
        em.getTransaction().commit();
    }
}
