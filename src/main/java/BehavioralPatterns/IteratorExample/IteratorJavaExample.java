package BehavioralPatterns.IteratorExample;

import java.util.*;

class Main {
    public static void main(String[] args) {
        String[] colors = {"Red", "Green", "Blue"};

        // Iterator
        for (int i = 0; i < colors.length; i++) {
            String color = colors[i];
            System.out.println(color);
        }

        List<String> colors2 = new ArrayList<>();
        colors2.add("Red");
        colors2.add("Green");
        colors2.add("Blue");

        Iterator<String> iterator = colors2.iterator();

        while (iterator.hasNext()) {
            String color = iterator.next();
            System.out.println(color);
        }
    }
}
