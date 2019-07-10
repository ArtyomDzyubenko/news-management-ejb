package com.epam.newsmanagement.ejb.dao;

import com.epam.newsmanagement.ejb.entity.News;
import java.util.List;

public interface NewsDAO {
    List<News> findAllNews();
    News findNewsById(Long id);
    void saveNews(News news);
    void updateNews(News news);
    void deleteNews(News news);
    boolean isNewsExist(String title);
}
