package aufgaben;

import static aufgaben.Operation.*;

/**
 * ! 1. Aufgabe: OperationsSimpleParallel
 */
public class OperationsSimpleParallel extends Thread {

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")) {
            A1.exec();
            A2.exec();
            A3.exec();
        }

        if (Thread.currentThread().getName().equals("Thread-1")) {
            B1.exec();
            B2.exec();
            B3.exec();
        }

        if (Thread.currentThread().getName().equals("Thread-2")) {
            C1.exec();
            C2.exec();
            C3.exec();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        init(args);

        final Thread t0 = new OperationsSimpleParallel();
        t0.start();

        final Thread t1 = new OperationsSimpleParallel();
        t1.start();

        final Thread t2 = new OperationsSimpleParallel();
        t2.start();

        //Wartet bis jeder fertig ist
        t0.join();
        t1.join();
        t2.join();
        System.out.println("complete");
    }
}