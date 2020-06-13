package lesson1;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList<T> fruits = new ArrayList<>();

    public Box(ArrayList<T> fruits) {
        this.fruits = fruits;
    }

    public float getWeight() {
        float weight = 0;
        for (T fruit: fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }
}
