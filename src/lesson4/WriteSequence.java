package lesson4;

public class WriteSequence {
    private final Object mon = new Object();
    private volatile char currentLetter = 'A';
    private char[] charSequence = {'A', 'B', 'C', 'D'};

    public void printChar(char c) {
        int number = -1;
        for (int i = 0; i < charSequence.length; i++) {
            if (c == charSequence[i])
                number = i;
            else continue;
        }
        if (number == -1)
            return;
        else {
            synchronized (mon) {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != c) {
                        try {
                            mon.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(c);
                    if (number == charSequence.length - 1)
                        currentLetter = charSequence[0];
                    else
                        currentLetter = charSequence[number + 1];
                    mon.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        WriteSequence w = new WriteSequence();
        Thread t1 = new Thread(() -> w.printChar('A'));
        Thread t2 = new Thread(() -> w.printChar('B'));
        Thread t3 = new Thread(() -> w.printChar('C'));
        Thread t4 = new Thread(() -> w.printChar('D'));
        Thread t5 = new Thread(() -> w.printChar('E'));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
