package servlets;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ContextListener implements ServletContextListener {

    private static final Logger LOGGER = Logger.getLogger(ContextListener.class);

    public void contextDestroyed(ServletContextEvent event) {
        logMessage("Servlet context destruction starts");
        logMessage("Servlet context destruction finished");
    }

    public void contextInitialized(ServletContextEvent event) {
        logMessage("Servlet context initialization starts");
        ServletContext servletContext = event.getServletContext();
        initLog4J(servletContext);
        initI18N(servletContext);
        logMessage("Servlet context initialization finished");
    }

    private void initLog4J(ServletContext servletContext) {
        logMessage("Log4J initialization started");
        try {
            PropertyConfigurator.configure(
                    servletContext.getRealPath("WEB-INF/log4j.properties"));
            LOGGER.debug("Log4j has been initialized");
        } catch (Exception ex) {
            logMessage("Cannot configure Log4j");
            LOGGER.error(ex.getMessage());
        }
        logMessage("Log4J initialization finished");
    }

    private void logMessage(String msg) {
        System.out.println("[ContextListener] " + msg);
    }

    private void initI18N(ServletContext servletContext) {
        LOGGER.debug("I18N subsystem initialization started");

        String localesVal = servletContext.getInitParameter("locale");
        if (localesVal == null || localesVal.isEmpty()) {
            LOGGER.warn("'locale' init parameter is empty, the default encoding will be used");
        } else {
            List<String> locales = new ArrayList();
            StringTokenizer st = new StringTokenizer(localesVal);
            while (st.hasMoreTokens()) {
                String localeName = st.nextToken();
                locales.add(localeName);
            }
            LOGGER.debug("Application attribute set: locale --> " + locales);
            servletContext.setAttribute("locale", locales);
        }

        LOGGER.debug("I18N subsystem initialization finished");
    }
}
