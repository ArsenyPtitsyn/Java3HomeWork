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
    }
}
