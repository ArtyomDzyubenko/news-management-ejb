package com.epam.newsmanagement.ejb.configuration;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class AppResourceConfig extends Application {
    public AppResourceConfig() {
        //default config
    }
}
