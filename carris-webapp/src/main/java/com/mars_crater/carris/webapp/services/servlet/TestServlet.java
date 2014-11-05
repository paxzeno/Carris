package com.mars_crater.carris.webapp.services.servlet;

import com.mars_crater.carris.interaction.services.MobileSiteRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Home servlet used for calculating the bus timers from home's nearest bus stop.
 */
@WebServlet(value="/test")
public class TestServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestServlet.class);

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("TEST SERVLET BEING RUN!");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

}
