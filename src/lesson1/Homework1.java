package lesson1;

import java.util.Arrays;

public class Homework1 {
    public static void main(String[] args) {

        GenericArrayElementsChanger<String> strArr = new GenericArrayElementsChanger<>
                ("Hi", "Hello", "Good morning", "Good evening",
                        "Good afternoon", "Good night", "welcome");
        System.out.println("before change: " + Arrays.toString(strArr.getArray()));

        strArr.changeElements(2, 4);
        System.out.println("after change: " + Arrays.toString(strArr.getArray()));
        strArr.changeElements(10, 12);
    }
}
