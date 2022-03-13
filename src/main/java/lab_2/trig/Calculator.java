package lab_2.trig;

public class Calculator {
    private final Sin sin;
    private final Cos cos;
    private final Tan tan;
    private final Cot cot;
    private final Sec sec;
    private final Csc csc;

    public Calculator(Sin sin, Cos cos, Tan tan, Cot cot, Sec sec, Csc csc) {
        this.sin = sin;
        this.cos = cos;
        this.tan = tan;
        this.cot = cot;
        this.sec = sec;
        this.csc = csc;
    }

    public Double calculate(Double x) {
        double sinResult = sin.calculate(x);
        double cosResult = cos.calculate(x);
        double tanResult = tan.calculate(x);
        double cotResult = cot.calculate(x);
        double secResult = sec.calculate(x);
        double cscResult = csc.calculate(x);

        return Math.pow((((((((((Math.pow((cosResult - tanResult), 2) * tanResult) / Math.pow(cosResult, 2)) / ((tanResult + cotResult) + Math.pow(tanResult, 2))) / Math.pow(secResult, 2)) - (cscResult - secResult)) - sinResult) + (tanResult + (cotResult * cosResult))) - ((sinResult - (secResult * ((cscResult + (sinResult + cosResult)) + sinResult))) + ((cscResult + tanResult) - secResult))) - ((secResult * Math.pow((secResult - ((sinResult - sinResult) + cotResult)), 3)) / (Math.pow(cscResult, 2) + sinResult))), 2);
    }
}
