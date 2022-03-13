package lab_2.trig;

import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;

public class Tan extends TrigFunction {
    private Sin sin;
    private Cos cos;

    public Tan(Double e) {
        super(e);
        this.sin = new Sin(e);
        this.cos = new Cos(e);
    }

    @Override
    public Double calculate(Double x) {
        x = checkX(x);

        double resultSin = sin.calculate(x);
        double resultCos = cos.calculate(x);

        if (resultCos == 0.0 && resultSin > 0) {
            return POSITIVE_INFINITY;
        } else if (resultCos == 0.0 && resultSin < 0) {
            return NEGATIVE_INFINITY;
        }

        return resultSin / resultCos;
    }
}
