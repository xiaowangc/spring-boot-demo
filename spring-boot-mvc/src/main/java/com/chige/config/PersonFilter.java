package com.chige.openfeign.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
//SpringBoot框架下使用WebFilter时，应该使用ServletComponentScan来扫描这个注解
@WebFilter(filterName = "personFilter",urlPatterns = {"/*"})
public class PersonFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("------PersonFilter init ------");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("------PersonFilter doFilter ------");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("------PersonFilter destroy ------");
    }
}
