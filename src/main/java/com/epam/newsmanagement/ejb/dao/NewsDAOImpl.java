package com.epam.newsmanagement.ejb.dao;

import com.epam.newsmanagement.ejb.entity.News;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Stateless
public class NewsDAOImpl implements NewsDAO {

    @PersistenceContext(name = "prod")
    EntityManager entityManager;


    @Override
    public List<News> findAllNews() {
        return entityManager.createNativeQuery("SELECT * FROM NEWS").getResultList();
    }
}
