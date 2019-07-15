package com.company.newsmanagement.ejb.service;

import com.company.newsmanagement.ejb.dtoConverter.NewsDTOConverter;
import com.company.newsmanagement.ejb.entity.News;
import com.company.newsmanagement.ejb.dao.NewsDAO;
import com.company.newsmanagement.ejb.dao.UserDAO;
import com.company.newsmanagement.ejb.dto.NewsDTO;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@Transactional
public class NewsServiceImpl implements NewsService {

    @EJB
    private NewsDAO newsDAO;

    @EJB
    private UserDAO userDAO;

    @Resource
    private SessionContext context;

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
        news.setUsername(context.getCallerPrincipal().getName());

        if (newsDAO.isNewsExist(news.getTitle())){
            return success;
        } else {
            newsDAO.saveNews(NewsDTOConverter.DTO2Entity(news));
            return !success;
        }
    }

    @Override
    public void updateNews(NewsDTO news) {
        if (actionAllowed(news)) {
            newsDAO.updateNews(NewsDTOConverter.DTO2Entity(news));
        }
    }

    @Override
    public void deleteNewsList(List<NewsDTO> newsList) {
       newsList.forEach(this::deleteNews);
    }

    private void deleteNews(NewsDTO news) {
        if (actionAllowed(news)) {
            newsDAO.deleteNews(NewsDTOConverter.DTO2Entity(news));
        }
    }

    private boolean actionAllowed(NewsDTO news) {
        return news.getUsername().equals(context.getCallerPrincipal().getName()) ||
                userDAO.getUserAuthority(context.getCallerPrincipal().getName()).getAuthority().equals("ROLE_ADMIN");

    }
}
