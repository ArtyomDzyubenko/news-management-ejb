package com.epam.newsmanagement.ejb.service;

import com.epam.newsmanagement.ejb.dao.NewsDAO;
import com.epam.newsmanagement.ejb.dto.NewsDTO;
import com.epam.newsmanagement.ejb.dtoConverter.NewsDTOConverter;
import com.epam.newsmanagement.ejb.entity.News;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@WebService(endpointInterface = "com.epam.newsmanagement.ejb.service.NewsSoapService")
public class NewsSoapServiceImpl implements NewsSoapService {

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
        return null;
    }

    @Override
    public boolean saveNews(NewsDTO news) {
        return false;
    }

    @Override
    public void updateNews(NewsDTO news) {

    }

    @Override
    public void deleteNewsList(List<Long> IDsList) {

    }
}
