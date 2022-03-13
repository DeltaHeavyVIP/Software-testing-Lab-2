package lab_2.log;

public class Log3 extends LogFunction {
    public Log3(Ln ln) {
        this.ln = ln;
    }

    private final Ln ln;

    @Override
    public Double calculate(Double x) {
        return ln.calculate(x) / ln.calculate(3.);
    }
}
