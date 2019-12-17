package Aufgaben;

import static Aufgaben.Operation.*;

/**
 * OperationsParallel
 */
public class OperationsParallel extends Thread{

    @Override
    public void run() {
        
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