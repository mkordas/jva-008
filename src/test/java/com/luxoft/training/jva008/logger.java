package com.luxoft.training.jva008;
import org.apache.log4j.Logger;

public class logger {
    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(Logger.class);
    public static void log(String s) {
    LOGGER.info(s);
    }
}
