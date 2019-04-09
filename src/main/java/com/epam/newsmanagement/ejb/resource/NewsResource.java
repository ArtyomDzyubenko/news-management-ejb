package com.epam.newsmanagement.ejb.resource;

import com.epam.newsmanagement.ejb.entity.News;
import com.epam.newsmanagement.ejb.service.NewsService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.inject.New;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
        List<News> newsList = newsService.findAllNews();

        return Response.ok(newsList).build();
    }

    /*@GET
    @Path("/news/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNewsById(@PathParam("id") Long id) {

    }*/
}
