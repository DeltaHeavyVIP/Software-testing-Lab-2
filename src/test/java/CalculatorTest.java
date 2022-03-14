import com.opencsv.exceptions.CsvException;
import lab_2.Calculator;
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
}
