package trig;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import lab_2.trig.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class trigStubsTest {

    private static Sin sin = mock(Sin.class);
    private static Cos cos = mock(Cos.class);
    private static Tan tan = mock(Tan.class);
    private static Cot cot = mock(Cot.class);
    private static Sec sec = mock(Sec.class);
    private static Csc csc = mock(Csc.class);
    private static TrigCalculator trigCalculator = null;
    private final double accuracy = 0.1;

    @BeforeAll
    public static void setup() throws IOException, CsvException {
        fillMock(sin, "src/test/resources/inputTrig/sinData.csv");
        fillMock(cos, "src/test/resources/inputTrig/cosData.csv");
        fillMock(tan, "src/test/resources/inputTrig/tanData.csv");
        fillMock(cot, "src/test/resources/inputTrig/cotData.csv");
        fillMock(sec, "src/test/resources/inputTrig/secData.csv");
        fillMock(csc, "src/test/resources/inputTrig/cscData.csv");
        trigCalculator = new TrigCalculator(sin, cos, tan, cot, sec, csc);
    }

    private static void fillMock(TrigFunction tf, String tableName) throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader(tableName))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                final double x = Double.parseDouble(record[0])*PI/Double.parseDouble(record[1]);
                final double y = Double.parseDouble(record[2]);
                when(tf.calculate(x)).thenReturn(y);
            }
        } catch (IOException | CsvException exp) {
            throw exp;
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/sinData.csv")
    @DisplayName("sin(x) test")
    void sinTest(Double divisible, Double divider, Double trueResult) {
        try {
            double x = divisible * PI / divider;
            double result = sin.calculate(x);
            assertEquals(trueResult, result, accuracy);
        } catch (ArithmeticException e) {
            assertEquals("Х should be <=0", e.getMessage());
        }
    }
}
