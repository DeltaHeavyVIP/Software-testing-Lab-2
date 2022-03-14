package trig;

import lab_2.trig.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Trig calculator")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestTrig {

    private final Sin sin;
    private final Cos cos;
    private final Tan tan;
    private final Cot cot;
    private final Sec sec;
    private final Csc csc;
    private final TrigCalculator trigCalculator;
    private final double accuracy = 0.1;


    TestTrig() {
        this.sin = new Sin();
        this.cos = new Cos();
        this.tan = new Tan();
        this.cot = new Cot();
        this.sec = new Sec();
        this.csc = new Csc();
        this.trigCalculator = new TrigCalculator(sin, cos, tan, cot, sec, csc);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/sinData.csv")
    @DisplayName("sin(x) test")
    void sinTest(Double divisible, Double divider, Double trueResult) {
        double x = divisible * Math.PI / divider;
        double result = sin.calculate(x);
        assertEquals(trueResult, result, accuracy);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/cosData.csv")
    @DisplayName("cos(x) test")
    void cosTest(Double divisible, Double divider, Double trueResult) {
        double x = divisible * Math.PI / divider;
        double result = cos.calculate(x);
        assertEquals(trueResult, result, accuracy);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/tanData.csv")
    @DisplayName("tan(x) test")
    void tanTest(Double divisible, Double divider, Double trueResult) {
        double x = divisible * Math.PI / divider;
        double result = tan.calculate(x);
        assertEquals(trueResult, result, accuracy);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/cotData.csv")
    @DisplayName("cot(x) test")
    void cotTest(Double divisible, Double divider, Double trueResult) {
        double x = divisible * Math.PI / divider;
        double result = cot.calculate(x);
        assertEquals(trueResult, result, accuracy);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/secData.csv")
    @DisplayName("sec(x) test")
    void secTest(Double divisible, Double divider, Double trueResult) {
        double x = divisible * Math.PI / divider;
        double result = sec.calculate(x);
        assertEquals(trueResult, result, accuracy);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/cscData.csv")
    @DisplayName("csc(x) test")
    void cscTest(Double divisible, Double divider, Double trueResult) {
        double x = divisible * Math.PI / divider;
        double result = csc.calculate(x);
        assertEquals(trueResult, result, accuracy);
    }

}
