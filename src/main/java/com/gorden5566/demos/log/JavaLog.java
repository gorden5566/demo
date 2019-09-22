package com.gorden5566.demos.log;

import java.io.IOException;
import java.util.logging.*;

/**
 * @author gorden5566
 * @date 2019/09/22
 */
public class JavaLog {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger("com.gorden5566.demos.log");

        logger.setLevel(Level.FINE);
        logger.setUseParentHandlers(false);

        Handler consoleHandler = getConsoleHandler();
        logger.addHandler(consoleHandler);

        Handler fileHandler = getFileHandler();
        logger.addHandler(fileHandler);

        logger.info("start log");
    }

    private static Handler getFileHandler() throws IOException {
        String path = JavaLog.class.getClassLoader().getResource("").getPath();
        Handler handler = new FileHandler(path + "/test.txt");

        handler.setLevel(Level.INFO);
        return handler;
    }

    private static Handler getConsoleHandler() {
        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.FINE);

        return handler;
    }
}
