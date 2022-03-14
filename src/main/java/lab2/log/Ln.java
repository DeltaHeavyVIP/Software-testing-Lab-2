package lab2.log;

public class Ln extends LogFunction {
    @Override
    public Double calculate(Double x) {
        x = checkX(x);
        double result = 0.0;
        for (int i = 1; i < 30; i++)
            result += Math.pow(-1, i - 1) * Math.pow(x - 1, i) / i;
        return result;
    }
}
