package lab2;

import lombok.Data;

import static java.lang.Double.*;

import java.util.HashMap;
import java.util.Map;

@Data
public abstract class AbstractFunction {

    private Map<Double, Double> mocks = new HashMap<>();
    private Double e;

    public abstract Double calculate(Double x);

    public Double checkX(double x) {
        if (isNaN(x) || isInfinite(x)) {
            return NaN;
        }
        return x;
    }

    public Double getFactorial(int n) {
        double ret;

        if (n == 0) {
            return 1.0;
        } else {
            ret = n * getFactorial(n - 1);
        }
        return ret;
    }

}
