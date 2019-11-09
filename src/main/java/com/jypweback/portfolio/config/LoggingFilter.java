package com.jypweback.portfolio.config;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by qkrwpdud1@gmail.com on 2019-11-09
 * Github : http://github.com/jypweback
 */

@Component
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final String url = ((HttpServletRequest) request).getRequestURI();

        if(url.matches("/(health|.+\\.(ico|js|css|woff2))")) {
            request.setAttribute("ignoreLogging", true);
        }

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
