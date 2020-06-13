package lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Homework1 {

    public static void main(String[] args) {

        GenericArrayChanger<String> strArr = new GenericArrayChanger<>
                ("Hi", "Hello", "Good morning", "Good evening",
                        "Good afternoon", "Good night", "welcome");
        System.out.println("before change: " + Arrays.toString(strArr.getArray()));

        // changeElements() check.
        strArr.changeElements(2, 4);
        System.out.println("after change: " + Arrays.toString(strArr.getArray()));
        strArr.changeElements(10, 12);

        // reorganizeToArrayList() check;
        ArrayList<String> list = new ArrayList<>();
        list = strArr.reorganizeToArrayList();
        System.out.println("fifth element of list is: " + list.get(5));

        // Check for Fruits and Boxes.
        // Fill boxes.
        Box<Apple> appleBox1 = new Box<>();
        appleBox1.fillBox(new Apple(), 90);

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.fillBox(new Apple(), 5);

        Box<Orange> orangeBox1 = new Box<>();
        orangeBox1.fillBox(new Orange(), 60);

        Box<Orange> orangeBox2 = new Box<>();
        orangeBox2.fillBox(new Orange(), 5);

        // Check method getWeight().
        System.out.println("Weight of appleBox1 is: " + appleBox1.getWeight());

        // Check method compare(...).
        System.out.println("Are the weights of appleBox1 and orangeBox1 the same? " +
                appleBox1.compare(orangeBox1));
        System.out.println("Are the weights of appleBox2 and orangeBox2 the same? " +
                appleBox2.compare(orangeBox2));

        // Check method shiftFruits(...).
        appleBox1.shiftFruits(appleBox2);
        System.out.printf("After shifting appleBox1 in appleBox2, the weights of this boxes are " +
                "%.1f and %.1f", appleBox1.getWeight(), appleBox2.getWeight());
    }
}
