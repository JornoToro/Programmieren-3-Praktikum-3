package aufgaben;

import static aufgaben.Operation.*;

import java.util.concurrent.CountDownLatch;

/**
 * ! 2. Aufgabe: OperationsCountDown
 */
public class OperationsCountDown extends Thread {

    public static CountDownLatch latch1;
    public static CountDownLatch latch2;

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")) {
            A1.exec();
            latch1.countDown();
            A2.exec();
            latch2.countDown();
            A3.exec();
        }

        if (Thread.currentThread().getName().equals("Thread-1")) {
            B1.exec();
            latch1.countDown();
            B2.exec();
            latch2.countDown();
            B3.exec();
        }

        if (Thread.currentThread().getName().equals("Thread-2")) {
            C1.exec();
            latch1.countDown();
            try {
                latch1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            C2.exec();
            latch2.countDown();
            try {
                latch2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            C3.exec();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //latch1 für c2: startet nach A1, B1, C1
        latch1 = new CountDownLatch(3);
        //latch2 für c3: startet nach zwei von drei A2, B2, C2
        latch2 = new CountDownLatch(2);

        init(args);

        final Thread t0 = new OperationsCountDown();
        t0.start();

        final Thread t1 = new OperationsCountDown();
        t1.start();

        final Thread t2 = new OperationsCountDown();
        t2.start();

        //Wartet bis jeder fertig ist
        t0.join();
        t1.join();
        t2.join();
        System.out.println("complete");
    }
}