package lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Homework1 {
    public static void main(String[] args) {

        GenericArrayChanger<String> strArr = new GenericArrayChanger<>
                ("Hi", "Hello", "Good morning", "Good evening",
                        "Good afternoon", "Good night", "welcome");
        System.out.println("before change: " + Arrays.toString(strArr.getArray()));

        // First method.
        strArr.changeElements(2, 4);
        System.out.println("after change: " + Arrays.toString(strArr.getArray()));
        strArr.changeElements(10, 12);

        // Second method
        ArrayList<String> list = new ArrayList<>();
        list = strArr.reorganizeToArrayList();
        System.out.println("First element of list is: " + list.get(0));
    }
}
