package lesson7;

import lesson7.testing.TestsHandler;

public class Main {
    public static void main(String[] args) {
        MainTestClass mainTestClass = new MainTestClass();
        TestsHandler.start(mainTestClass.getClass());
    }
}
