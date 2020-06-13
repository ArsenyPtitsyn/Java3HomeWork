package lesson1;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList<T> fruits;

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

    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001f;
    }

    public void shiftFruits(Box<T> anotherBox) {
        for (int i = 0; i < this.fruits.size(); i++) {
            anotherBox.fruits.add(this.fruits.get(i));
        }
    }

    public void addFruit() {

    }
}
