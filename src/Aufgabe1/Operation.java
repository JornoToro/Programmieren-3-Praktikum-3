package Aufgabe1;

public enum Operation
{
	    A1, A2, A3, B1, B2, B3, C1, C2, C3;

    /** Dauer der Operation in Millisekunden. */
    private int duration;

    //--hide
    /** Protokolliert Start und Ende der Operationen. */
    private static Tracer tracer;

    /**
     * Initialisiert einen Tracer.
     * Wenn die Systemproperty tracer definiert ist, liefert sie den FQCN.
     */
    static {
        try {
            final String tracerTypename = System.getProperty("tracer");
            tracer = tracerTypename == null ? new SysoutTracer() : (Tracer)Class.forName(tracerTypename).newInstance();
        }
        catch(ReflectiveOperationException e) {
            System.err.println(e);
            throw new RuntimeException(e);
        }

    }
    //--see

    /** Initialisiert die Operationen mit Laufzeiten.
     * Diese Methoden muss vor dem Start der Operationen genau einmal aufgerufen werden.
     * @param args Strings mit Laufzeiten in Millisekunden, einer fuer jede Operation.
     * Fehlende Strings ergaenzt die Methode durch den Letztgenannten.
     * Ueberzaehlige Strings verfallen.
     * Wenn alle Strings fehlen, gilt eine Laufzeit von 1 Sekunde.
     */
    public static void init(String... args) {
        if(args.length == 0)
            init("1000");
        else {
            assert tracer.clear();
            for(Operation operation: values())
                operation.duration = Integer.parseInt(args[operation.ordinal() < args.length
                    ? operation.ordinal()
                    : args.length - 1]);
        }
    }

    /** Fuehrt diese Operation aus.
     */
    public void exec() {
        if(duration < 1)
            throw new IllegalStateException(this + ": not initialized");
        try {
            assert tracer.logCall(this);
            Thread.sleep(duration);
            assert tracer.logExit(this);
        }
        catch(InterruptedException e) {
           // throw new RuntimeException("unexpected interrupt");
        }
    }


}