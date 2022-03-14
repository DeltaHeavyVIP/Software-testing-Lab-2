package trig;

import lab_2.trig.*;
import lab_2.utils.CsvLogger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static java.lang.Math.PI;

@DisplayName("Trig logger")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestTrigLogger {

    private final Sin sin;
    private final Cos cos;
    private final Tan tan;
    private final Cot cot;
    private final Sec sec;
    private final Csc csc;
    private final TrigCalculator trigCalculator;
    private static CsvLogger csvLogger;
    private final double accuracy = 0.1;

    TestTrigLogger() {
        this.sin = new Sin();
        this.cos = new Cos();
        this.tan = new Tan();
        this.cot = new Cot();
        this.sec = new Sec();
        this.csc = new Csc();
        this.trigCalculator = new TrigCalculator(sin, cos, tan, cot, sec, csc);

    }

    @Test
    @DisplayName("Logger sin(x) test")
    void sinTest() {
        csvLogger = new CsvLogger("sin.csv", -6 * PI, -3 * PI, 0.5 * PI);
        csvLogger.logger(sin);
    }

    @Test
    @DisplayName("Logger cos(x) test")
    void cosTest() {
        csvLogger = new CsvLogger("cos.csv", -6 * PI, -3 * PI, 0.5 * PI);
        csvLogger.logger(cos);
    }

    @Test
    @DisplayName("Logger tan(x) test")
    void tanTest() {
        csvLogger = new CsvLogger("tan.csv", -6 * PI, -3 * PI, 0.5 * PI);
        csvLogger.logger(sin);
    }


    @Test
    @DisplayName("Logger cot(x) test")
    void cotTest() {
        csvLogger = new CsvLogger("cot.csv", -6 * PI, -3 * PI, 0.5 * PI);
        csvLogger.logger(sin);
    }

    @Test
    @DisplayName("Logger sec(x) test")
    void secTest() {
        csvLogger = new CsvLogger("sec.csv", -6 * PI, -3 * PI, 0.5 * PI);
        csvLogger.logger(sin);
    }

    @Test
    @DisplayName("Logger csc(x) test")
    void cscTest() {
        csvLogger = new CsvLogger("csc.csv", -6 * PI, -3 * PI, 0.5 * PI);
        csvLogger.logger(sin);
    }
}