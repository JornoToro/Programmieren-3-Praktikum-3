package aufgaben;

import static aufgaben.Operation.*;

/**
 * ! 3. Aufgabe: OperationsParallel
 */
public class OperationsParallel_2 extends Thread {

    // c2: startet nach A1, B1, C1
    // c3: startet nach zwei von drei A2, B2, C2

    @Override
    public void run() {
        int lock1 = 0;
        Object lock = new Object();

        if (Thread.currentThread().getName().equals("Thread-0")) {
            A1.exec();

            synchronized (lock) {
                try {
                    if(lock1 < 2){
                        lock1++;
                        lock.wait();
                    }else{
                        lock.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            A2.exec();
            A2.exec();

            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            A3.exec();
        }

        if (Thread.currentThread().getName().equals("Thread-1")) {
            B1.exec();

            synchronized (lock) {
                try {
                    if(lock1 < 2){
                        lock1++;
                        lock.wait();
                    }else{
                        lock.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            B2.exec();
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            B3.exec();
        }

        if (Thread.currentThread().getName().equals("Thread-2")) {
            C1.exec();
            synchronized (lock) {
                try {
                    if(lock1 < 2){
                        lock1++;
                        lock.wait();
                    }else{
                        lock.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            /* synchronized (lock) {
                lock.notifyAll();;
            } */
            
            C2.exec();
           
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            C3.exec();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        init(args);

        final Thread t0 = new OperationsParallel_2();
        t0.start();

        final Thread t1 = new OperationsParallel_2();
        t1.start();

        final Thread t2 = new OperationsParallel_2();
        t2.start();

        // Wartet bis jeder fertig ist
        t0.join();
        t1.join();
        t2.join();
        System.out.println("complete");
    }
}