package BehavioralPatterns.StateExample;

interface State {
    void writeName(Context context, String name);
}

class LowerCaseState implements State {
    @Override
    public void writeName(Context context, String name) {
        System.out.println(name.toLowerCase());
        context.setState(new UpperCaseState());
    }
}

class UpperCaseState implements State {
    @Override
    public void writeName(Context context, String name) {
        System.out.println(name.toUpperCase());
        context.setState(new LowerCaseState());
    }
}

class Context {
    private State state;

    public Context(State state) {
        this.state = state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void writeName(String name) {
        state.writeName(this, name);
    }
}

class Main {
    public static void main(String[] args) {
        Context context = new Context(new LowerCaseState());
        context.writeName("Hello World");
        context.writeName("Goodbye World");
    }
}

