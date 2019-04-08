package com.epam.newsmanagement.ejb.service;

import com.epam.newsmanagement.ejb.dao.NewsDAO;
import com.epam.newsmanagement.ejb.entity.News;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Stateless
public class NewsServiceImpl implements NewsService {

    @EJB
    private NewsDAO newsDAO;

    @Override
    public List<News> findAllNews() {
        return newsDAO.findAllNews();
    }
}
