package lab_2;

import lombok.Data;

import static java.lang.Double.*;
import static java.lang.Math.PI;

@Data
public abstract class AbstractFunction {

    public abstract Double calculate(Double x);

    public Double checkX(double x) {
        if (isNaN(x) || isInfinite(x)) {
            return NaN;
        }
        return x;
    }

    public static Double getFactorial(int n) {
        double ret;

        if (n == 0) {
            return 1.0;
        } else {
            ret = n * getFactorial(n - 1);
        }
        return ret;
    }

}
