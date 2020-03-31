package com.caoheng.www.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(filterName = "dirtyFilter", value = "/login.html")
public class DrityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        ServletRequest req = (ServletRequest) new Dirty(request);
        filterChain.doFilter(req, servletResponse);
    }

    static class Dirty extends HttpServletRequestWrapper {
        static List<String> dirtyList = new ArrayList<String>();

        static {
            dirtyList.add("sb");
            dirtyList.add("cnm");
        }

        public Dirty(HttpServletRequest request) {
            super(request);
        }

        @Override
        public String getParameter(String name) {
            String str =super.getParameter(name);
            for (String s : dirtyList) {
                if (str.contains(s)) {
                   return str.replace(s, "***");
                }
            }
            return str;
        }
    }

    @Override
    public void destroy() {

    }
}
