package com.company.newsmanagement.ejb.service;

import com.company.newsmanagement.ejb.dto.NewsDTO;
import java.util.List;

public interface NewsService {
    List<NewsDTO> findAllNews();
    NewsDTO findNewsById(Long id);
    boolean saveNews(NewsDTO news);
    void updateNews(NewsDTO news);
    void deleteNewsList(List<NewsDTO> newsList);
}
