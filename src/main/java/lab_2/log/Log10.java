package lab_2.log;

public class Log10 extends LogFunction{
    private final Ln ln;
    public Log10(Ln ln) {
        this.ln = ln;
    }

    @Override
    public Double calculate(Double x) {
        x = checkX(x);

        return ln.calculate(x)/ 2.30258509299;
    }
}