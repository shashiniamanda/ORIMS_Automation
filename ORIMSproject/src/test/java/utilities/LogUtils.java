package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

public class LogUtils {

        private static Logger logger;

        static {
            try {
                String logPath = "src/test/resources/logs/selenium_console_log.txt";
                FileHandler fileHandler = new FileHandler(logPath, true);
                fileHandler.setFormatter(new SimpleFormatter());

                // Prevent duplicate handlers
                if (logger == null) {
                    logger = Logger.getLogger(LogUtils.class.getName());
                    logger.addHandler(fileHandler);
                    logger.setUseParentHandlers(false);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void info(String message) {
            logger.info(message);
        }

        public static void warning(String message) {
            logger.warning(message);
        }

        public static void severe(String message) {
            logger.severe(message);
        }
        // Inner class for custom log formatting
        private static class CustomFormatter extends Formatter {
            private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

            @Override
            public String format(LogRecord record) {
                StringBuilder builder = new StringBuilder();

                // Add timestamp
                builder.append(dateFormat.format(new Date(record.getMillis()))).append(" - ");

                // Add log level
                builder.append(record.getLevel()).append(": ");

                // Add class name and method name
                builder.append(record.getSourceClassName()).append(".");
                builder.append(record.getSourceMethodName()).append(" - ");

                // Add the log message
                builder.append(record.getMessage()).append("\n");

                return builder.toString();
            }
        }

    }

