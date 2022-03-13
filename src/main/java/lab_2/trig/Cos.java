package lab_2.trig;

import static java.lang.Math.*;

public class Cos extends TrigFunction {

    private Sin sin;

    public Cos(Double e) {
        super(e);
        this.sin = new Sin(e);
    }

    @Override
    public Double calculate(Double x) {
        x = checkX(x);

        if (x == -PI / 2 || x == -3 * PI / 2) {
            return 0.0;
        }
        double resultSin = sin.calculate(x);
        double resultCos = sqrt(1 - pow(resultSin, 2));

        if (x < -PI / 2 && x > -3 * PI / 2) {
            resultCos *= -1;
        }
        return resultCos;
    }
}
