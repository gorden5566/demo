package com.gorden5566.learn.netty.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author gorden5566
 * @date 2019/08/25
 */
public class DefaultServletFactory {
    public static Map<String, Class<? extends Servlet>> servletMap = new ConcurrentHashMap<>();

    public static void addServletWithMapping(Class<? extends Servlet> servlet, String pathSpec) {
        if (pathSpec == null) {
            return;
        }

        servletMap.put(pathSpec, servlet);
    }

    public static Servlet getMappedServlet(String uri) {
        if (servletMap == null) {
            return null;
        }

        Class<? extends Servlet> clazz = servletMap.get(uri);

        return clazz == null ? new Default404Servlet() : getInstance(clazz);
    }

    private static Servlet getInstance(Class<? extends Servlet> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class Default404Servlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().println("<h1>404 Page Not Found</h1>");
        }
    }
}
