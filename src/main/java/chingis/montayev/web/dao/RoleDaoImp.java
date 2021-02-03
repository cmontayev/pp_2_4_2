package chingis.montayev.web.dao;

import chingis.montayev.web.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RoleDaoImp implements RoleDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getAll() {
        return entityManager.createQuery("select r from Role r",Role.class).getResultList();
    }


    @Override
    public void add(Role role) {
     entityManager.persist(role);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.find(Role.class,id));
    }

    @Override
    public Role getById(Long id) {
        TypedQuery<Role>query=entityManager.createQuery(
                "select role from Role role WHERE role.id = :id",Role.class);
        return query
                .setParameter("id",id)
                .getSingleResult();
    }

    @Override
    public Role getByName(String name) {
        TypedQuery<Role>query = entityManager.createQuery(
                "select role from  Role  role WHERE role.role =:roleName",Role.class
        );
        return query
        .setParameter("roleName",name)
        .getSingleResult();
    }

    @Override
    public void upDate(Role roleUpdDate) {
        entityManager.merge(roleUpdDate);
    }
}
