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
    private static Calculator calculator = null;

    @BeforeAll
    public static void setup() throws IOException, CsvException {
        fillMock(sin, "/inputTrig/sinData.csv");
        fillMock(cos, "/inputTrig/cosData.csv");
        fillMock(tan, "/inputTrig/tanData.csv");
        fillMock(cot, "/inputTrig/cotData.csv");
        fillMock(sec, "/inputTrig/secData.csv");
        fillMock(csc, "/inputTrig/cscData.csv");
        calculator = new Calculator(sin, cos, tan, cot, sec, csc);
    }

    private static void fillMock(TrigFunction tf, String tableName) throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader(tableName))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                final double x = Double.parseDouble(record[0]);
                final double y = Double.parseDouble(record[1]);
                when(tf.apply(x)).thenReturn(y);
            }
        } catch (IOException | CsvException exp) {
            throw exp;
        }
    }

}
