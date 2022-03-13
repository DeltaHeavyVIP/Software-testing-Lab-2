package lab_2.trig;

import lab_2.AbstractFunction;

import static java.lang.Double.*;
import static java.lang.Math.PI;

public class Sec extends AbstractFunction {

    private Cos cos;

    public Sec(Double e) {
        super(e);
        this.cos = new Cos(e);
    }

    @Override
    public Double calculate(Double x) {
        x = checkX(x);

        double resultCos = cos.calculate(x);
        double result = 1.0 / resultCos;

        if (result == POSITIVE_INFINITY)
            return POSITIVE_INFINITY;
        else if (result == NEGATIVE_INFINITY)
            return NEGATIVE_INFINITY;

        return result;
    }
}
