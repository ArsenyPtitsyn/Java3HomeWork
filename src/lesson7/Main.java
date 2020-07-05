package lesson7;

import testing.TestsHandler;

public class Main {
    public static void main(String[] args) {
        MainTestClass mainTestClass = new MainTestClass();
        TestsHandler.start(mainTestClass.getClass());

        System.out.println();
        ConsiderationClass.outClassInfo(String.class);
    }
}
