package com.epam.newsmanagement.ejb.service;

import com.epam.newsmanagement.ejb.dto.NewsDTO;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
@Transactional
@WebService(endpointInterface = "com.epam.newsmanagement.ejb.service.NewsSoapService")
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
    public boolean saveNews(NewsDTO news) {
        return newsService.saveNews(news);
    }

    @Override
    public void updateNews(NewsDTO news) {
        newsService.updateNews(news);
    }

    @Override
    public void deleteNewsList(List<Long> IDsList) {
        newsService.deleteNewsList(IDsList);
    }
}
