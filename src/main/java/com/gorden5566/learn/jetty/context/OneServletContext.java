package com.gorden5566.learn.jetty.context;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ListenerHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.EnumSet;

/**
 * @author gorden5566
 * @date 2019/08/17
 */
public class OneServletContext {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        context.setResourceBase(System.getProperty("java.io.tmpdir"));
        server.setHandler(context);

        context.addServlet(context.addServlet(DumpServlet.class, "/dump/*"), "*.dump");
        context.addServlet(HelloServlet.class, "/hello/");
        context.addServlet(DefaultServlet.class, "/");

        context.addFilter(TestFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST));
        context.addFilter(TestFilter.class, "/test", EnumSet.of(DispatcherType.REQUEST, DispatcherType.ASYNC));
        context.addFilter(TestFilter.class, "*.test", EnumSet.of(DispatcherType.REQUEST, DispatcherType.INCLUDE, DispatcherType.FORWARD));

        context.getServletHandler().addListener(new ListenerHolder(InitListener.class));
        context.getServletHandler().addListener(new ListenerHolder(RequestListener.class));

        server.start();
        server.dumpStdErr();
        server.join();
    }

    public static class TestFilter implements Filter {
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            chain.doFilter(request, response);
        }

        @Override
        public void destroy() {
        }
    }

    public static class InitListener implements ServletContextListener {
        @Override
        public void contextInitialized(ServletContextEvent servletContextEvent) {
        }

        @Override
        public void contextDestroyed(ServletContextEvent servletContextEvent) {
        }
    }

    public static class RequestListener implements ServletRequestListener {
        @Override
        public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        }

        @Override
        public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        }
    }

    @SuppressWarnings("serial")
    public static class HelloServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request,
                             HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println("<h1>Hello from HelloServlet</h1>");
        }
    }

    @SuppressWarnings("serial")
    public static class DumpServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println("<h1>DumpServlet</h1><pre>");
            response.getWriter().println("requestURI=" + request.getRequestURI());
            response.getWriter().println("contextPath=" + request.getContextPath());
            response.getWriter().println("servletPath=" + request.getServletPath());
            response.getWriter().println("pathInfo=" + request.getPathInfo());
            response.getWriter().println("session=" + request.getSession(true).getId());

            String r = request.getParameter("resource");
            if (r != null) {
                response.getWriter().println("resource(" + r + ")=" + getServletContext().getResource(r));
            }

            response.getWriter().println("</pre>");
        }
    }
}
