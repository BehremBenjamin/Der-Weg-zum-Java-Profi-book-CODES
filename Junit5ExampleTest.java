import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Junit5ExampleTest {

    @Test
    void testAssertTrue() {
        List<String> names = new ArrayList<>();

        names.add("Benjamin");
        names.add("Behrem");
        names.clear();

        Assertions.assertTrue(names.isEmpty());
    }

    @Test
    public void testAssertFalse() {
        final List<Integer> primes = List.of(2, 3, 5, 7);
        Assertions.assertFalse(primes.contains(7));

    }

    @Test
    public void assertNull() {
        Assertions.assertNull(null);
    }

    @Test
    public void assertNotNull() {
        Assertions.assertNotNull(null, "Unexpected null value");

    }

    @Test
    public void testEquals() {
        Assertions.assertEquals("EXPECTED", "expected".toUpperCase());

    }

    @Test
    public void assertEqualsWithPrecision() {
        Assertions.assertEquals(2.75, 2.74999999, 0.1);

    }

    @Test
    void testDoubleWithDeviation() {
        final double EPSILON = 0.0001;
        final double result = 10.0 / 3.0 * 100;

        Assertions.assertEquals(333.3333, result, EPSILON);
    }

    @Test
    void testFailWithExceptionJUnit5() {
        Assertions.assertThrows(java.lang.NumberFormatException.class, () -> {
            // provocated fail
            final int value = Integer.parseInt("Error provoked");
        });
    }
}
