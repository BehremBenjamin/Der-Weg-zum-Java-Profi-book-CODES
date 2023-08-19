import org.apache.commons.math3.primes.Primes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class FirstParameterizedTest {


    @ParameterizedTest (name = "run {index} : ''{0}'' is not empty")
    @ValueSource(strings = {"Tim", "Tom", "", "Mike"})
    void isNotEmpty(String value) {

        Assertions.assertFalse(value.isEmpty());
    }

    @ParameterizedTest(name = "run {index} : ''{0}'' is not a prime")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7})
    void ensureIsPrime(int value) {
        Assertions.assertTrue(Primes.isPrime(value));

    }



}
