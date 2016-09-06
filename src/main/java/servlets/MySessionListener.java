package servlets;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.jsp.jstl.core.Config;

public class MySessionListener implements HttpSessionListener {

    private static final Logger LOGGER = Logger.getLogger(MySessionListener.class);

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        LOGGER.debug("MySessionListener starts");
        HttpSession session = httpSessionEvent.getSession();
        if (session.getAttribute("defaultLocale") == null) {
            Config.set(session, "javax.servlet.jsp.jstl.fmt.locale", "ru");
            session.setAttribute("defaultLocale", "ru");
        }
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
