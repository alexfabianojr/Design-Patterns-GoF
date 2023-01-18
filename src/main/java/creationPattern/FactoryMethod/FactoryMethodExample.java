package creationPattern.FactoryMethod;

class AppMain {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("console");
        assert logger != null;
        logger.log("Hello, world!");
    }
}

class LoggerFactory {
    private LoggerFactory() {}

    public static Logger getLogger(String type) {
        if (type.equals("console")) {
            return new ConsoleLogger();
        } else if (type.equals("file")) {
            return new FileLogger();
        }
        return null;
    }
}

class ConsoleLogger implements Logger {
    public void log(String message) {
        System.out.println("Logging to console: " + message);
    }
}

class FileLogger implements Logger {
    public void log(String message) {
        System.out.println("Logging to file: " + message);
    }
}

interface Logger {
    void log(String message);
}
