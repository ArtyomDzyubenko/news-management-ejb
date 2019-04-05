package com.epam.newsmanagement.ejb.service;

import com.epam.newsmanagement.ejb.entity.News;

import java.util.List;

public interface NewsService {
    List<News> findAllNews();
}
