package BehavioralPatterns.ChainOfResponsibilityExample;

// Enumera��o de tipos de solicita��o
enum RequestType {
    TYPE1, TYPE2
}

// Interface do manipulador
interface Handler {
    void setNext(Handler handler);

    void handleRequest(Request request);
}

// Implementa��o do manipulador
class ConcreteHandler1 implements Handler {
    private Handler nextHandler;

    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    public void handleRequest(Request request) {
        if (request.getType() == RequestType.TYPE1) {
            System.out.println("ConcreteHandler1 tratou a solicita��o.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

// Implementa��o do manipulador
class ConcreteHandler2 implements Handler {
    private Handler nextHandler;

    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    public void handleRequest(Request request) {
        if (request.getType() == RequestType.TYPE2) {
            System.out.println("ConcreteHandler2 tratou a solicita��o.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

// Classe solicita��o
class Request {
    private final RequestType type;

    public Request(RequestType type) {
        this.type = type;
    }

    public RequestType getType() {
        return type;
    }
}

// Classe cliente que usa a cadeia de manipuladores
class Client {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        handler1.setNext(handler2);

        Request request1 = new Request(RequestType.TYPE1);
        Request request2 = new Request(RequestType.TYPE2);

        handler1.handleRequest(request1);
        handler1.handleRequest(request2);
    }
}
