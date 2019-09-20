package com.luxoft.training.jva008;

import org.apache.log4j.spi.LoggerFactory;

public class Logger {
    private static final org.apache.log4j.Logger LOGGER =
            org.apache.log4j.Logger.getLogger(Logger.class);

    public static void log(String s) {
        LOGGER.info(s);
    }
}