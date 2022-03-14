package lab2.log;

public class LogCalculator {
    private final Ln ln;
    private final Log3 log3;
    private final Log5 log5;
    private final Log10 log10;

    public LogCalculator(Ln ln, Log3 log3, Log5 log5, Log10 log10) {
        this.ln = ln;
        this.log3 = log3;
        this.log5 = log5;
        this.log10 = log10;
    }

    public Double calculate(Double x) {
        return Math.pow(((((log10.calculate(x) * log5.calculate(x)) - log5.calculate(x)) / log3.calculate(x)) - log3.calculate(x)), 2);
    }
}
