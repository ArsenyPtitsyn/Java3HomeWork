package lesson1;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList<T> fruits = new ArrayList<>();

    public Box() {
    }

    public float getWeight() {
        float weight = 0;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001f;
    }

    public void shiftFruits(Box<T> anotherBox) {
        for (int i = this.fruits.size() - 1; i >= 0 ; i--) {
            anotherBox.addFruit(this.getFruit(i));
        }
    }

    public void addFruit(T fruit) {
        this.fruits.add(fruit);
    }

    public void fillBox(T fruit, int count) {
        for (int i = 0; i < count; i++) {
            this.addFruit(fruit);
        }
    }

    public T getFruit(int index) {
        T fruit = fruits.get(index);
        fruits.remove(index);
        return fruit;
    }
}
