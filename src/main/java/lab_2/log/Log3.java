package lab_2.log;

public class Log3 extends LogFunction{
    private final Ln ln;
    public Log3(Ln ln) {
        this.ln = ln;
    }

    @Override
    public Double calculate(Double x) {
        return ln.calculate(x)/ ln.calculate(3.);
    }
}
