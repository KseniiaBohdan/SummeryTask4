package servlets.filter;

import data.entity.Role;
import data.entity.User;
import org.apache.log4j.Logger;
import servlets.constant.PageConstant;
import servlets.welcome.LoginServlet;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AccessFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(AccessFilter.class);
    private static final String ADMIN = "admin";
    private static final String USER = "user";
    private static List<String> adminUrl = new ArrayList();
    private static List<String> userUrl = new ArrayList();

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOGGER.debug("Filter starts");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute(USER);
        String url = req.getServletPath();
        String[] urlS = url.split("/");

        if (Objects.nonNull(user)) {
            if (user.getRole() == Role.ADMIN && (urlS[1].equals(ADMIN))) {
                LOGGER.debug("User!=null, user.role=admin and url=admin/*");
                chain.doFilter(request, response);
            } else if (user.getRole() == Role.USER && (urlS[1].equals(USER))) {
                LOGGER.debug("User!=null, user.role=user and url=user/*");
                chain.doFilter(request, response);
            } else {
                resp.sendRedirect(PageConstant.LOGIN_SERVLET);
            }
        } else {
            resp.sendRedirect(PageConstant.LOGIN_SERVLET);
        }
    }

    @Override
    public void destroy() {
        LOGGER.debug("AccessFilter destruction finished");
    }
}
