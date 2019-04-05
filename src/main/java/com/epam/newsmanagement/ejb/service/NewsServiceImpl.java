package com.epam.newsmanagement.ejb.service;

import com.epam.newsmanagement.ejb.dao.NewsDAO;
import com.epam.newsmanagement.ejb.entity.News;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class NewsServiceImpl implements NewsService {

    @Inject
    private NewsDAO newsDAO;

    @Override
    public List<News> findAllNews() {
        return newsDAO.findAllNews();
    }
}
