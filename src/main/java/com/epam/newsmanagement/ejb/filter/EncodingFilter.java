package com.epam.newsmanagement.ejb.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private static final String FILTERABLE_CONTENT_TYPE = "application/x-www-form-urlencoded";
    private static final String ENCODING_DEFAULT = "UTF-8";
    private static final String ENCODING_INIT_PARAM_NAME = "encoding";
    private static String encoding;

    @Override
    public void init(FilterConfig config) {
        encoding = config.getInitParameter(ENCODING_INIT_PARAM_NAME);

        if (encoding == null) {
            encoding = ENCODING_DEFAULT;
        }
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String contentType = req.getContentType();
        if (contentType != null && contentType.startsWith(FILTERABLE_CONTENT_TYPE)) {
            req.setCharacterEncoding(encoding);
        }

        chain.doFilter(req, resp);
    }
}
