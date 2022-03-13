package lab_2.trig;

import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;

public class Csc extends TrigFunction {

    private Sin sin;

    public Csc(Double e) {
        super(e);
        this.sin = new Sin(e);
    }

    @Override
    public Double calculate(Double x) {
        x = checkX(x);

        double resultSin = sin.calculate(x);
        double result = 1.0 / resultSin;

        if (result == POSITIVE_INFINITY)
            return POSITIVE_INFINITY;
        else if (result == NEGATIVE_INFINITY)
            return NEGATIVE_INFINITY;

        return result;
    }
}
