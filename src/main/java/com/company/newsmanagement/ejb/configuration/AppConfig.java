package com.company.newsmanagement.ejb.configuration;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class AppConfig extends Application {
    public AppConfig() {
        //default config
    }
}
