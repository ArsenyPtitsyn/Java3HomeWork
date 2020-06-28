package lesson5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(CARS_COUNT);
        Semaphore smp = new Semaphore(MainClass.CARS_COUNT / 2);
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            final Car c = cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
            final int w = i;
            new Thread(() -> {
                try {
                    System.out.println(c.getName() + " готовится");
                    Thread.sleep(500 + (int)(Math.random() * 800));
                    System.out.println(c.getName() + " готов");
                    cdl.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}