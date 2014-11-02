package com.mars_crater.carris.webapp.services.servlet;

import com.mars_crater.carris.interaction.services.MobileSiteRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Home servlet used for calculating the bus timers from home's nearest bus stop.
 */
public class HomeServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MobileSiteRequest request = new MobileSiteRequest();
        request.execute();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

}
