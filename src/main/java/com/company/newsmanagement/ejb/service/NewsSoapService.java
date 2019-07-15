package com.company.newsmanagement.ejb.service;

import com.company.newsmanagement.ejb.dto.NewsDTO;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface NewsSoapService {
    @WebMethod
    List<NewsDTO> findAllNews();

    @WebMethod
    NewsDTO findNewsById(Long id);

    @WebMethod
    void saveNews(NewsDTO news);

    @WebMethod
    void updateNews(NewsDTO news);

    @WebMethod
    void deleteNewsList(List<NewsDTO> newsList);
}
