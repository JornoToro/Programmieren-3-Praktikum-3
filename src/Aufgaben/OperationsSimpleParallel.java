package aufgaben;

import static aufgaben.Operation.*;
/**
 * ! 1. Aufgabe: OperationsSimpleParallel
 */
public class OperationsSimpleParallel  {
    public static void main(String[] args) throws InterruptedException {
        init(args);
      
        Thread t0 = new Thread(() -> {A1.exec();A2.exec();A3.exec();});
        Thread t1 = new Thread(() -> {B1.exec();B2.exec();B3.exec();});
        Thread t2 = new Thread(() -> {C1.exec();C2.exec();C3.exec();}); 
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