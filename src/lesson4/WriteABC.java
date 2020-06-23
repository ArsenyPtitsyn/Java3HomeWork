package lesson4;

public class WriteABC {
    private final Object monitor = new Object();
    private volatile char currentLetter = 'A';

    public void printA() {
        synchronized (monitor) {
            for (int i = 0; i < 5; i++) {
                while (currentLetter != 'A') {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("A");
                currentLetter = 'B';
                monitor.notifyAll();
            }
        }
    }

    public void printB() {
        synchronized (monitor) {
            for (int i = 0; i < 5; i++) {
                while (currentLetter != 'B') {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("B");
                currentLetter = 'C';
                monitor.notifyAll();
            }
        }
    }

    public void printC() {
        synchronized (monitor) {
            for (int i = 0; i < 5; i++) {
                while (currentLetter != 'C') {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("C");
                currentLetter = 'A';
                monitor.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        WriteABC w = new WriteABC();
        Thread t1 = new Thread(() -> w.printA());
        Thread t2 = new Thread(() -> w.printB());
        Thread t3 = new Thread(() -> w.printC());
        t1.start();
        t2.start();
        t3.start();
    }
}
