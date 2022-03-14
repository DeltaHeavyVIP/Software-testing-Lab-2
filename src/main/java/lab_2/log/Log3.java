package lab_2.log;

public class Log3 extends LogFunction {
    public Log3(Ln ln) {
        this.ln = ln;
    }

    private final Ln ln;

    @Override
    public Double calculate(Double x) {
        x = checkX(x);
        return ln.calculate(x) / 1.09861228867;
    }
}
