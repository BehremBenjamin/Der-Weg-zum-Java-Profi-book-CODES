import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.time.temporal.Temporal;

public class SecondParametrizedTest {

    @ParameterizedTest(name = "{index}: {0} + {1} = {2}")
    @CsvSource({"1, 1, 2", "2, -2, 0", "3, 4, 7"})
    void testAdd(int first, int second, int expected) {
        int sum = first + second;
        Assertions.assertEquals(expected, sum);
    }

    @ParameterizedTest
    @CsvSource({"2014-03-15, 2014-01-01", "2014-06-16, 2014-04-01", "2014-09-15, 2014-07-01", "2014-11-15, 2014-10-01"})
    void adjustToFirstDayOfQuarter(LocalDate startDate, LocalDate expected) {
        final Temporal result = new FirstDayOfQuarter().adjustInto(startDate);
        Assertions.assertEquals(expected, result);
    }
}
