import com.opencsv.exceptions.CsvException;
import lab_2.Calculator;
import lab_2.log.*;
import lab_2.trig.*;
import log.LogStubsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import trig.TrigStubsTest;

import java.io.IOException;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("CalculatorTest")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/calcData.csv")
    @DisplayName("allMock")
    void allMock(Double x, Double trueResult) throws IOException, CsvException {
        LogStubsTest.setup();
        TrigStubsTest.setup();
        Calculator calculator = new Calculator(LogStubsTest.logCalculator, TrigStubsTest.trigCalculator);
        double result = calculator.calculate(x);
        assertEquals(trueResult, result, 0.01);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/calcData.csv")
    @DisplayName("trigMock")
    void trigMock(Double x, Double trueResult) throws IOException, CsvException {
        TrigStubsTest.setup();
        Ln ln = new Ln();
        Log3 log3 = new Log3(ln);
        Log5 log5 = new Log5(ln);
        Log10 log10 = new Log10(ln);
        LogCalculator logCalculator = new LogCalculator(ln, log3, log5, log10);
        Calculator calculator = new Calculator(logCalculator, TrigStubsTest.trigCalculator);
        double result = calculator.calculate(x);
        assertEquals(trueResult, result, 0.05);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/calcData.csv")
    @DisplayName("logMock")
    void logMock(Double x, Double trueResult) throws IOException, CsvException {
        LogStubsTest.setup();
        var sin = new Sin();
        var cos = new Cos();
        var tan = new Tan();
        var cot = new Cot();
        var sec = new Sec();
        var csc = new Csc();
        var trigCalculator = new TrigCalculator(sin, cos, tan, cot, sec, csc);
        Calculator calculator = new Calculator(LogStubsTest.logCalculator, trigCalculator);
        double result = calculator.calculate(x);
        assertEquals(trueResult, result, result / 100);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/calcData.csv")
    @DisplayName("noMock")
    void noMock(Double x, Double trueResult) throws IOException, CsvException {
        var sin = new Sin();
        var cos = new Cos();
        var tan = new Tan();
        var cot = new Cot();
        var sec = new Sec();
        var csc = new Csc();
        var trigCalculator = new TrigCalculator(sin, cos, tan, cot, sec, csc);
        var ln = new Ln();
        var log3 = new Log3(ln);
        var log5 = new Log5(ln);
        var log10 = new Log10(ln);
        var logCalculator = new LogCalculator(ln, log3, log5, log10);
        Calculator calculator = new Calculator(logCalculator, trigCalculator);
        double result = calculator.calculate(x);
        assertEquals(trueResult, result, result / 50);
    }

}
