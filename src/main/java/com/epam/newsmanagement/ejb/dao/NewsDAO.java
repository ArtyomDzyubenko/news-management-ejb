package com.epam.newsmanagement.ejb.dao;

import com.epam.newsmanagement.ejb.entity.News;
import java.util.List;

public interface NewsDAO {
    List<News> findAllNews();
}
