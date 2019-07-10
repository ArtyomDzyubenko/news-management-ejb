package com.epam.newsmanagement.ejb.resource;

import com.epam.newsmanagement.ejb.dto.NewsDTO;
import com.epam.newsmanagement.ejb.entity.News;
import com.epam.newsmanagement.ejb.service.NewsService;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("/news")
public class NewsResource {
    private final static String CHARSET = ";charset=utf-8";

    @EJB
    NewsService newsService;

    @GET
    @Produces(MediaType.APPLICATION_JSON + CHARSET)
    public Response getAllNews() {
        List<NewsDTO> newsList = newsService.findAllNews();

        return Response.ok(newsList).build();
    }

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON + CHARSET)
    public Response getNewsById(@PathParam("id") Long id) {
        NewsDTO news = newsService.findNewsById(id);

        return Response.ok(news).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response.Status addNews(@Valid NewsDTO news) {
        boolean success = newsService.saveNews(news);

        if (!success) {
            return Response.Status.CONFLICT;
        }

        return Response.Status.CREATED;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response.Status updateNews(@Valid NewsDTO news) {
        newsService.updateNews(news);

        return Response.Status.OK;
    }

    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    public Response.Status deleteNewsList(List<News> newsList) {
        newsService.deleteNewsList(newsList);

        return Response.Status.NO_CONTENT;
    }
}
