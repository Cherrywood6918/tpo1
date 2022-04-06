package function;

import function.FactorialException;
import function.PowerSeriesForSinFunction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PowerSeriesForSinFunctionTest {

    @ParameterizedTest
    @ValueSource(doubles = {Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY})
    void ifArgIsNotFunctionScopeThanReturnCorrectResponse(double x) throws FactorialException {
        assertEquals(Double.NaN, PowerSeriesForSinFunction.sinApply(x));
    }

    @ParameterizedTest
    @CsvSource({"1, 1.5708",
            "-1, -1.5708",
            "0.8660, 1.0472",
            "-0.8660, -1.0472",
            "0.7071, 0.7854",
            "-0.7071, -0.7854",
            "0.5, 0.5236",
            "-0.5, -0.5236",
            "0.8660, 2.0944",
            "-0.8660, -2.0944",
            "0.7071, 2.3562",
            "-0.7071, -2.3562",
            "0.5, 2.6180",
            "-0.5, -2.6180",})
    void trigonometricCircleTest(double y, double x) throws FactorialException {
        assertEquals(y, PowerSeriesForSinFunction.sinApply(x), 0.0001);
    }


    @ParameterizedTest
    @ValueSource(doubles = {Math.PI, -Math.PI})
    void limitFunctionTest(double x) throws FactorialException {
        assertEquals(0, PowerSeriesForSinFunction.sinApply(x), 0.0001);
    }

    @Test
    void zeroTest() throws FactorialException {
        assertEquals(0,PowerSeriesForSinFunction.sinApply(0), 0.001);
    }

    @Test
    void ifFactorialOutOfBoundsLongReturnException() {
        assertThrows(FactorialException.class,()->PowerSeriesForSinFunction.calculateFactorial(21));
    }

    @Test
    @DisabledOnJre(value = JRE.JAVA_8)
    void ifNotCalculatedFactorialReturnNaN() throws FactorialException {
        System.out.println(System.getProperty("java.version"));
        assertTrue(System.getProperty("java.version").startsWith("1.8"));
//        assertEquals(Double.NaN, PowerSeriesForSinFunction.sinApply(7*Math.PI/3));
    }
}
