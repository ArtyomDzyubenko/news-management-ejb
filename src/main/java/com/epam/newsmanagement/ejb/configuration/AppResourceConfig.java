package com.epam.newsmanagement.ejb.configuration;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class AppResourceConfig extends ResourceConfig {
    public AppResourceConfig() {
        packages("com.epam.newsmanagement.ejb.resource");
    }
}
