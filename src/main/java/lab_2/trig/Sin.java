package lab_2.trig;

import static java.lang.Math.*;

public class Sin extends TrigFunction {

    {
        getMocks().put(0.0, 0.0);
        getMocks().put(-PI / 6, -1.0/2);
        getMocks().put(-PI / 4,-sqrt(2)/2);
        getMocks().put(-PI / 3,-sqrt(3)/2);
        getMocks().put(-PI / 2,-1.0);
        getMocks().put(-2 * PI / 3,-sqrt(3)/2);
        getMocks().put(-3 * PI / 4, -sqrt(2)/2);
        getMocks().put(-5 * PI / 6,-1.0/2 );
        getMocks().put(-PI,0.0);
        getMocks().put(-7*PI / 6,1.0/2);
        getMocks().put(-5*PI / 4,sqrt(2)/2);
        getMocks().put(-4*PI / 3, sqrt(3)/2);
        getMocks().put(-3*PI / 2, 1.0);
        getMocks().put(-5* PI / 3,sqrt(3)/2);
        getMocks().put(-7 * PI / 4, sqrt(2)/2);
        getMocks().put(-11 * PI / 6, 1.0/2);
    }

    public Sin(Double e) {
        super(e);
    }

    @Override
    public Double calculate(Double x) {
        x = checkX(x);

        if (x == 0 || x == -PI) {
            return 0.0;
        }

        int n = 1;
        double resultSin = 0;
        while (Math.abs((Math.pow(-1, n - 1) / getFactorial(2 * n - 1)) * Math.pow(x, 2 * n - 1)) > getE()) {
            resultSin += (Math.pow(-1, n - 1) / getFactorial(2 * n - 1)) * Math.pow(x, 2 * n - 1);
            n++;
        }
        return resultSin;
    }

    public long getFactorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}
