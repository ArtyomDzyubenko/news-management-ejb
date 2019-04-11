package com.epam.newsmanagement.ejb.dao;

import com.epam.newsmanagement.ejb.entity.News;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class NewsDAOImpl implements NewsDAO {

    //@PersistenceContext(name = "persistUnit")
    private EntityManager entityManager = Persistence.createEntityManagerFactory("persistUnit").createEntityManager();

    @Override
    public List<News> findAllNews() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<News> criteriaQuery = criteriaBuilder.createQuery(News.class);
        Root<News> root = criteriaQuery.from(News.class);
        criteriaQuery.select(root);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<News> findUserNews(String username) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<News> criteriaQuery = criteriaBuilder.createQuery(News.class);
        Root<News> root = criteriaQuery.from(News.class);
        criteriaQuery
                .select(root)
                .where(criteriaBuilder
                        .like(root.get("username"), username));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public News findNewsById(Long id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<News> criteriaQuery = criteriaBuilder.createQuery(News.class);
        Root<News> root = criteriaQuery.from(News.class);
        criteriaQuery
                .select(root)
                .where(criteriaBuilder
                        .equal(root.get("id"), id));

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public void saveNews(News news) {
        entityManager.persist(news);
    }

    @Override
    public void updateNews(News news) {
        News updated = findNewsById(news.getId());

        updated.setTitle(news.getTitle());
        updated.setBrief(news.getBrief());
        updated.setContent(news.getContent());

        entityManager.merge(updated);
    }

    @Override
    public void deleteNewsList(List<Long> IDsList) {
        String hql = "DELETE from News as nws WHERE nws.id = ?1";

        IDsList.forEach(item -> entityManager.createQuery(hql).setParameter(1, item).executeUpdate());
    }

    @Override
    public boolean isNewsExist(String title) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<News> criteriaQuery = criteriaBuilder.createQuery(News.class);
        Root<News> root = criteriaQuery.from(News.class);
        criteriaQuery
                .select(root)
                .where(criteriaBuilder
                        .equal(root.get("title"), title));

        return entityManager.createQuery(criteriaQuery).getResultList().size() > 0;
    }


}
