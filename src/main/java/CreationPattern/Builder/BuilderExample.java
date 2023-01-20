package CreationPattern.Builder;

class AppMain {
    public static void main(String[] args) {
        PizzaBuilder builder = new PizzaBuilder();
        Pizza pizza = builder.setDough("thin").setSauce("tomato").setTopping("cheese").build();

        System.out.println(pizza.getTopping());
    }
}

class PizzaBuilder {
    private final Pizza pizza;

    public PizzaBuilder() {
        pizza = new Pizza();
    }

    public PizzaBuilder setDough(String dough) {
        pizza.setDough(dough);
        return this;
    }

    public PizzaBuilder setSauce(String sauce) {
        pizza.setSauce(sauce);
        return this;
    }

    public PizzaBuilder setTopping(String topping) {
        pizza.setTopping(topping);
        return this;
    }

    public Pizza build() {
        return pizza;
    }
}

class Pizza {
    private String dough = "";
    private String sauce = "";
    private String topping = "";

    public void setDough(String dough) {
        this.dough = dough;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public String getDough() {
        return dough;
    }

    public String getSauce() {
        return sauce;
    }

    public String getTopping() {
        return topping;
    }
}
