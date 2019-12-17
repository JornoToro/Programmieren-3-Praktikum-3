package Aufgaben;


public class SysoutTracer implements Tracer
{
    private long initMillis = System.currentTimeMillis();

    @Override
    public boolean logCall(Operation operation) {
        log(operation, " =>");
        return true;
    }

    @Override
    public boolean logExit(Operation operation) {
        log(operation, " <=");
        return true;
    }

    @Override
    public boolean clear() {
        initMillis = 0;
        return true;
    }

    public boolean log(Operation operation, String message) {
        if(initMillis < 1)
            initMillis = System.currentTimeMillis();
        final int TABSIZE = 2;
        final int indent = TABSIZE*(operation.toString().charAt(0) - '@');
        System.out.printf("[%6d]%" + indent + "s%s%s%n",
                          System.currentTimeMillis() - initMillis,
                          "",
                          operation,
                          message);
        return true;
    }

}