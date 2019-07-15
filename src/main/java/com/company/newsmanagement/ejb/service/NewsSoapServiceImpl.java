package com.company.newsmanagement.ejb.service;

import com.company.newsmanagement.ejb.dto.NewsDTO;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
@Transactional
@WebService(endpointInterface = "com.company.newsmanagement.ejb.service.NewsSoapService")
public class NewsSoapServiceImpl implements NewsSoapService {

    @EJB
    private NewsService newsService;

    @Override
    public List<NewsDTO> findAllNews() {
        return newsService.findAllNews();
    }

    @Override
    public NewsDTO findNewsById(Long id) {
        return newsService.findNewsById(id);
    }

    @Override
    public void saveNews(NewsDTO news) {
        news.setId(null);
        newsService.saveNews(news);
    }

    @Override
    public void updateNews(NewsDTO news) {
        newsService.updateNews(news);
    }

    @Override
    public void deleteNewsList(List<NewsDTO> newsList) {
        newsService.deleteNewsList(newsList);
    }
}
