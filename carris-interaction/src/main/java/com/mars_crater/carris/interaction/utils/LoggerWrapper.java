package com.mars_crater.carris.interaction.utils;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;

/**
 * Wrap up the logger into a more detailed signature.
 */
public final class LoggerWrapper {

    /**
     * Logger wrapper constructor, utility class will not be instantiated.
     */
    private LoggerWrapper() {
        //Empty
    }

    /**
     * Looking for element log, logs what element is being looked up and where.
     *
     * @param logger logger object.
     * @param looking4this element being looked up.
     * @param at driver to submit site title/location.
     */
    public static void lookingForElementDebug(Logger logger, String looking4this, WebDriver at) {
        logger.debug("Looking for {} @ {}", looking4this, at.getTitle());
    }

    /**
     * Debug logger, picks the text inserted and puts corresponding elements in the text
     * and on the final of the sentence adds the site location/title.
     *
     * @param logger logger object.
     * @param text text to put on the log.
     * @param at driver to submit site title/location.
     * @param elements text elements to be put on the log sentence.
     */
    public static void debug(Logger logger, String text, WebDriver at, Object... elements) {
        Object[] objects = new Object[elements.length+1];
        for (int i = 0; i < elements.length; i++) {
            objects[i] = elements[i];
        }
        objects[objects.length-1] = at.getTitle();
        logger.debug(text + " @ {}", objects);
    }

    /**
     * Debug logger, logs text inserted and on the final of the sentence adds
     * the site location/title.
     *
     * @param logger logger object.
     * @param text text to put on the log.
     * @param at driver to submit site title/location.
     */
    public static void debug(Logger logger, String text, WebDriver at) {
        logger.debug(text + " @ {}", at.getTitle());
    }

    public static void error() {

    }
}
