package praktikum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IngredientTypeTest {

    @Test
    void valuesShouldReturnCorrectTypes() {
        IngredientType[] types = IngredientType.values();

        assertEquals(2, types.length);
        assertEquals(IngredientType.SAUCE, types[0]);
        assertEquals(IngredientType.FILLING, types[1]);
    }
}
