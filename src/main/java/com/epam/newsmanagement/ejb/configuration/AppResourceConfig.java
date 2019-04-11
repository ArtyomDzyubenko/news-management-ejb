package com.epam.newsmanagement.ejb.configuration;

import com.epam.newsmanagement.ejb.service.NewsSoapServiceImpl;
import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;
import javax.xml.ws.Endpoint;

@ApplicationPath("/api")
public class AppResourceConfig extends ResourceConfig {
    public AppResourceConfig() {
        packages("com.epam.newsmanagement.ejb.resource");
        Endpoint.publish("http://localhost:8084/news-management/soap/news", new NewsSoapServiceImpl());
    }
}
