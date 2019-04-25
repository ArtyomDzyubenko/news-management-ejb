package com.epam.newsmanagement.ejb.dao;

import com.epam.newsmanagement.ejb.entity.Authority;
import com.epam.newsmanagement.ejb.entity.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class UserDAOImpl implements UserDAO {

    @PersistenceContext(unitName = "persistUnit")
    private EntityManager entityManager;

    @Override
    public Authority getUserAuthority(String username) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Authority> criteriaQuery = criteriaBuilder.createQuery(Authority.class);
        Root<Authority> root = criteriaQuery.from(Authority.class);
        criteriaQuery
                .select(root)
                .where(criteriaBuilder.like(root.get("username"), username));

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }
}
