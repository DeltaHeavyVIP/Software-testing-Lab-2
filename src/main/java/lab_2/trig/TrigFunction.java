package lab_2.trig;

import lab_2.AbstractFunction;

public class TrigFunction extends AbstractFunction {

    private Sin sin;
    private Cos cos;
    private Tan tan;
    private Cot cot;
    private Sec sec;
    private Csc csc;

    public TrigFunction(Double e) {
        super(e);
        this.sin = new Sin(e);
        this.cos = new Cos(e);
        this.tan = new Tan(e);
        this.cot = new Cot(e);
        this.sec = new Sec(e);
        this.csc = new Csc(e);
    }

    /*
    ((((((((((((cos(x) - tan(x)) ^ 2) * tan(x)) / (cos(x) ^ 2)) / ((tan(x) + cot(x)) + (tan(x) ^ 2))) / (sec(x) ^ 2)) - (csc(x) - sec(x))) - sin(x)) + (tan(x) + (cot(x) * cos(x)))) - ((sin(x) - (sec(x) * ((csc(x) + (sin(x) + cos(x))) + sin(x)))) + ((csc(x) + tan(x)) - sec(x)))) - ((sec(x) * ((sec(x) - ((sin(x) - sin(x)) + cot(x))) ^ 3)) / ((csc(x) ^ 2) + sin(x)))) ^ 2)
     */
    @Override
    public Double calculate(Double x) {
        double resultSin = sin.calculate(x);
        double resultCos = cos.calculate(x);
        double resultTan = tan.calculate(x);
        double resultCot = cot.calculate(x);
        double resultSec = sec.calculate(x);
        double resultCsc = csc.calculate(x);

        double result = 0.0;
        return result;
    }
}
