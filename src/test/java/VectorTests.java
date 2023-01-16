import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class VectorTests {
    @Test
    public void addTest() {
        Vector vector1 = new Vector(3, new double[]{1, 2, 3});
        Vector vector2 = new Vector(3, new double[]{1, 2, 3});
        Vector result = vector1.add(vector2);

        Vector expected = new Vector(3, new double[]{2, 4, 6});

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void multiplyByScalarTest() {
        Vector vector1 = new Vector(3, new double[]{2, 4, 6});
        Vector result = vector1.multiplyByScalar(2);

        Vector expected = new Vector(3, new double[]{4, 8, 12});

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void toStringTest() {
        String expected = "{34,61, 55,98, 47,09}";
        Vector vector = new Vector(3, new double[]{34.61, 55.98, 47.09});
        String result = vector.toString();

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("reverseWithDataSource")
    public void reverseWithData(Vector vector, Vector expected) {
        Vector result = vector.reverse();

        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> reverseWithDataSource() {
        Vector vector1 = new Vector(3, new double[]{1, 2, 3});
        Vector expected1 = new Vector(3, new double[]{-1, -2, -3});

        Vector vector2 = new Vector(3, new double[]{10, 20, 30});
        Vector expected2 = new Vector(3, new double[]{-10, -20, -30});

        Vector vector3 = new Vector(3, new double[]{100, 200, 300});
        Vector expected3 = new Vector(3, new double[]{-100, -200, -300});


        return Stream.of(
                Arguments.of(vector1, expected1),
                Arguments.of(vector2, expected2),
                Arguments.of(vector3, expected3));
    }
}