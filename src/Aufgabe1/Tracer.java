package Aufgabe1;

public interface Tracer
{
    boolean logCall(Operation operation);

    boolean logExit(Operation operation);

    boolean clear();

}