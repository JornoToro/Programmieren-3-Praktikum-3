package Aufgaben;

import static Aufgaben.Operation.*;

/**
 * ! 3. Aufgabe: OperationsParallel
 */
public class OperationsParallel extends Thread {

    // c2: startet nach A1, B1, C1
    // c3: startet nach zwei von drei A2, B2, C2

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")) {
            A1.exec();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            A2.exec();
            A2.exec();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            A3.exec();
        }

        if (Thread.currentThread().getName().equals("Thread-1")) {
            B1.exec();
            try {
                wait();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            B2.exec();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            B3.exec();
        }

        if (Thread.currentThread().getName().equals("Thread-2")) {

            C1.exec();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            C2.exec();
            notifyAll();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            C3.exec();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        init(args);

        Thread t0 = new OperationsSimpleParallel();
        t0.start();

        Thread t1 = new OperationsSimpleParallel();
        t1.start();

        Thread t2 = new OperationsSimpleParallel();
        t2.start();

        //Wartet bis jeder fertig ist
        t0.join();
        t1.join();
        t2.join();
        System.out.println("complete");
    }
}