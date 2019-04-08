package com.epam.newsmanagement.ejb.resource;

import com.epam.newsmanagement.ejb.entity.News;
import com.epam.newsmanagement.ejb.service.NewsService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

//@Stateless
@Path("/news")
//@Consumes({MediaType.APPLICATION_JSON})
public class NewsResource {

    @EJB
    NewsService newsService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray findAllNews() {
        JsonArrayBuilder jsonList = Json.createArrayBuilder();
        List<News> newsList = newsService.findAllNews();
        newsList.stream().map(news -> news.toJson()).forEach(jsonList::add);


        return jsonList.build();
    }
}
