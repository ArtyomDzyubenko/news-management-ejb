package com.epam.newsmanagement.ejb.service;

import com.epam.newsmanagement.ejb.dao.NewsDAO;
import com.epam.newsmanagement.ejb.dto.NewsDTO;
import com.epam.newsmanagement.ejb.dtoConverter.NewsDTOConverter;
import com.epam.newsmanagement.ejb.entity.News;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Stateless
public class NewsServiceImpl implements NewsService {

    @EJB
    private NewsDAO newsDAO;

    @Override
    public List<NewsDTO> findAllNews() {
        List<News> newsList = newsDAO.findAllNews();

        return newsList.stream()
                .map(NewsDTOConverter::Entity2DTO)
                .collect(Collectors.toList());
    }

    @Override
    public NewsDTO findNewsById(Long id) {
        News news = newsDAO.findNewsById(id);

        return NewsDTOConverter.Entity2DTO(news);
    }

    @Override
    public boolean saveNews(NewsDTO news) {
        boolean success = false;

        /*newsDAO.saveNews(NewsDTOConverter.DTO2Entity(news));
        return true;*/
        if (newsDAO.isNewsExist(news.getTitle())){
            return success;
        } else {
            newsDAO.saveNews(NewsDTOConverter.DTO2Entity(news));
            return !success;
        }
    }

    @Override
    public void updateNews(NewsDTO news) {
        newsDAO.updateNews(NewsDTOConverter.DTO2Entity(news));
    }

    @Override
    public void deleteNewsList(List<Long> IDsList) {
        newsDAO.deleteNewsList(IDsList);
    }
}
