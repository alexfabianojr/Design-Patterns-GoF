package BehavioralPatterns;

// Interface de comando
interface Command {
    void execute();
}

// Implementação do comando
class ConcreteCommand implements Command {
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public void execute() {
        receiver.action();
    }
}

// Receptor do comando
class Receiver {
    public void action() {
        System.out.println("Receptor: executando uma ação.");
    }
}

// Classe invocadora que executa o comando
class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}

// Classe cliente que usa o comando
class Client {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker(command);
        invoker.executeCommand();
    }
}


