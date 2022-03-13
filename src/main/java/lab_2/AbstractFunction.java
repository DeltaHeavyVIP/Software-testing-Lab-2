package lab_2;

import lombok.Data;

import static java.lang.Double.*;
import static java.lang.Math.PI;

@Data
public abstract class AbstractFunction {
    private Double e;

    public AbstractFunction(Double e) {
        this.e = e;
    }

    public abstract Double calculate(Double x);

    public static Double checkX(double x) {
        if (isNaN(x) || isInfinite(x)) {
            return NaN;
        }
        if (x > 0) {
            throw new ArithmeticException("Х должен быть <=0");
        }
        return x % (2 * PI);
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
