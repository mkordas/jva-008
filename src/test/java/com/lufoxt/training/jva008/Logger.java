package com.lufoxt.training.jva008;


public class Logger {

    private static final org.apache.log4j.Logger LOGGER  =
        org.apache.log4j.Logger.getLogger(Logger.class);
    public static void log(String s) {
        LOGGER.info(s);
    }
}
