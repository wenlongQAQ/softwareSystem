package com.zzut.softwaresystem.filter;


import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Component
@WebListener("/*")
public class UserNumberListener implements HttpSessionListener, ServletContextListener {

    public UserNumberListener() {

    }

    public void sessionCreated(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        int userNumber = (int) context.getAttribute("userNumber");
        userNumber++;
        System.out.println("create");
        context.setAttribute("userNumber", userNumber);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        int userNumber = (int) context.getAttribute("userNumber");
        if (userNumber != 0) {
            userNumber--;
        }
        else
        {
            userNumber=0;
        }
        context.setAttribute("userNumber", userNumber);

    }

    public void contextDestroyed(ServletContextEvent arg0) {

    }

    public void contextInitialized(ServletContextEvent ce) {
        ServletContext context = ce.getServletContext();
        Integer userNumber = (Integer) context.getAttribute("userNumber");
        if (userNumber == null){
            userNumber = 0;
        }else userNumber++;
        System.out.println("init");

        context.setAttribute("userNumber", userNumber);
    }

}
