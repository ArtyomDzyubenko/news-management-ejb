package com.epam.newsmanagement.ejb.resource;

import com.epam.newsmanagement.ejb.dto.NewsDTO;
import com.epam.newsmanagement.ejb.service.NewsService;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("/news")
public class NewsResource {

    @EJB
    NewsService newsService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllNews() {
        List<NewsDTO> newsList = newsService.findAllNews();

        return Response.ok(newsList).build();
    }

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNewsById(@PathParam("id") Long id) {
        NewsDTO news = newsService.findNewsById(id);

        return Response.ok(news).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response.Status addNews(NewsDTO news) {
        boolean success = newsService.saveNews(news);

        if (!success) {
            return Response.Status.CONFLICT;
        }

        return Response.Status.CREATED;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response.Status updateNews(NewsDTO news) {
        newsService.updateNews(news);

        return Response.Status.OK;
    }

    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    public Response.Status deleteNewsList(List<Long> IDsList) {
        newsService.deleteNewsList(IDsList);

        return Response.Status.NO_CONTENT;
    }
}
