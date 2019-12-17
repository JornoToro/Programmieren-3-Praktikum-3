package Aufgabe1;

import static Aufgabe1.Operation.*;

/**
 * OperationsSimpleParallel
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

    public static void main(String[] args) {
        init(args);

        Thread t0 = new OperationsSimpleParallel();
        t0.start();

        Thread t1 = new OperationsSimpleParallel();
        t1.start();

        Thread t2 = new OperationsSimpleParallel();
        t2.start();

    }
}