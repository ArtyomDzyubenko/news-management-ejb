package com.epam.newsmanagement.ejb.service;

import com.epam.newsmanagement.ejb.dao.NewsDAO;
import com.epam.newsmanagement.ejb.dao.UserDAO;
import com.epam.newsmanagement.ejb.dto.NewsDTO;
import com.epam.newsmanagement.ejb.dtoConverter.NewsDTOConverter;
import com.epam.newsmanagement.ejb.entity.Authority;
import com.epam.newsmanagement.ejb.entity.News;
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
        String username = context.getCallerPrincipal().getName();
        Authority authority = userDAO.getUserAuthority(username);

        List<News> newsList;

        if (authority.getAuthority().contains("ADMIN")) {
            newsList = newsDAO.findAllNews();
        } else {
            newsList = newsDAO.findUserNews(username);
        }

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
        newsDAO.updateNews(NewsDTOConverter.DTO2Entity(news));
    }

    @Override
    public void deleteNewsList(List<Long> IDsList) {
        newsDAO.deleteNewsList(IDsList);
    }
}
