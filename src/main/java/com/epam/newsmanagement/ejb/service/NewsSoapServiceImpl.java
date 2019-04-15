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
    public boolean saveOrUpdateNews(NewsDTO news) {
        boolean saved = true;

        if (news.getId() == 0) {
            news.setId(null);
            newsService.saveNews(news);

            return saved;
        }

        newsService.updateNews(news);

        return !saved;
    }

    @Override
    public void deleteNewsList(List<Long> IDsList) {
        newsService.deleteNewsList(IDsList);
    }
}
