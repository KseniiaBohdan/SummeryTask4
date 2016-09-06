package servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.jstl.core.Config;

import org.apache.log4j.Logger;

public class EncodingFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(EncodingFilter.class);

    private String encoding;

    public void destroy() {
        LOGGER.debug("Filter destruction starts");
        LOGGER.debug("Filter destruction finished");
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        LOGGER.debug("Filter starts");

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        LOGGER.trace("Request uri --> " + httpRequest.getRequestURI());

        String reqEncoding = request.getCharacterEncoding();
        if (reqEncoding == null) {
            LOGGER.trace("Request encoding = null, set encoding --> " + encoding);
            request.setCharacterEncoding(encoding);
        }

        LOGGER.debug("Filter finished");
        chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) throws ServletException {
        LOGGER.debug("Filter initialization starts");
        encoding = fConfig.getInitParameter("encoding");
        LOGGER.trace("Encoding from web.xml --> " + encoding);
        LOGGER.debug("Filter initialization finished");
    }

}