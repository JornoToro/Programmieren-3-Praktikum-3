package aufgaben;

import static aufgaben.Operation.*;
/**
 * ! 3. Aufgabe: OperationsParallel
 */
public class OperationsParallel {
    // c2: startet nach A1, B1, C1
    // c3: startet nach zwei von drei A2, B2, C2
    public static Object lock;
    public static int t;
    public static int t2;
    public static void main(String[] args) throws InterruptedException {
        init(args);

        lock = new Object();
        t = 2;
        t2 = 1;

        Thread t0 = new Thread(() -> {
            A1.exec();
            synchronized (lock) {
                try {
                    if(t > 0){
                        t--;
                        lock.wait();
                    }else{
                        lock.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            A2.exec();
            synchronized (lock) {
                try {
                    if(t2 > 0){
                        t2--;
                        lock.wait();
                    }else{
                        lock.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            A3.exec();
        });

        Thread t1 = new Thread(() -> {
            B1.exec();
            synchronized (lock) {
                try {
                    if(t > 0){
                        t--;
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
                    if(t2 > 0){
                        t2--;
                        lock.wait();
                    }else{
                        lock.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            B3.exec();
        });

        Thread t2 = new Thread(() -> {
            C1.exec();
            synchronized (lock) {
                try {
                    if(t > 0){
                        t--;
                        lock.wait();
                    }else{
                        lock.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            C2.exec();
           
            C3.exec();
        }); 
        
        t0.start();
        t1.start();
        t2.start();

        //Wartet bis jeder fertig ist
        t0.join();
        t1.join();
        t2.join();
        System.out.println("complete");
    }
}