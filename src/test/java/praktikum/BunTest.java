package praktikum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

public class BunTest {
    @ParameterizedTest
    @MethodSource("bunDataProvider")
    void bunConstructorShouldSetValuesCorrectly(String name, float price) {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
        assertEquals(price, bun.getPrice(), 0.001);
    }

    private static Stream<Arguments> bunDataProvider() {
        return Stream.of(
                Arguments.of("Флюоресцентная булка R2-D3", (float)100.0),
                Arguments.of("Краторная булка", (float)200.0),
                Arguments.of("", (float)0.0)

        );
    }
}
