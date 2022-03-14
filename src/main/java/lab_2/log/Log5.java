package lab_2.log;

public class Log5 extends LogFunction{
    private final Ln ln;
    public Log5(Ln ln) {
        this.ln = ln;
    }

    @Override
    public Double calculate(Double x) {
        x = checkX(x);

        return ln.calculate(x)/ ln.calculate(5.);
    }
}
