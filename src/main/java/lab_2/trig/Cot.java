package lab_2.trig;

import lab_2.AbstractFunction;

import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;

public class Cot extends AbstractFunction {

    private Sin sin;
    private Cos cos;

    public Cot(Double e) {
        super(e);
        this.sin = new Sin(e);
        this.cos = new Cos(e);
    }

    @Override
    public Double calculate(Double x) {
        x = checkX(x);

        double resultSin = sin.calculate(x);
        double resultCos = cos.calculate(x);

        if (resultSin == 0.0 && resultCos > 0) {
            return POSITIVE_INFINITY;
        } else if (resultSin == 0.0 && resultCos < 0) {
            return NEGATIVE_INFINITY;
        }

        return resultCos / resultSin;
    }
}
