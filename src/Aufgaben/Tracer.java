package aufgaben;

public interface Tracer
{
    boolean logCall(Operation operation);

    boolean logExit(Operation operation);

    boolean clear();

}