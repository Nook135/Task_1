package praktikum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {

    @ParameterizedTest
    @MethodSource("ingredientDataProvider")
    void ingredientShouldStoreAllProperties(IngredientType type, String name, float price) {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
        assertEquals(name, ingredient.getName());
        assertEquals(price, ingredient.getPrice(), (float)0.01);
    }

    private static Stream<Arguments> ingredientDataProvider() {
        return Stream.of(
                Arguments.of(IngredientType.SAUCE, "Соус Spicy-X", (float)90.0),
                Arguments.of(IngredientType.SAUCE, "Соус фирменный Space Sauce", (float)80.0),
                Arguments.of(IngredientType.SAUCE, "Соус традиционный галактический", (float)15.0),
                Arguments.of(IngredientType.SAUCE, "Соус с шипами Антарианского плоскоходца", (float)88.0),
                Arguments.of(IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", (float)1337.0),
                Arguments.of(IngredientType.FILLING, "Говяжий метеорит (отбивная)", (float)3000.0),
                Arguments.of(IngredientType.FILLING, "Биокотлета из марсианской Магнолии", (float)424.0),
                Arguments.of(IngredientType.FILLING, "Филе Люминесцентного тетраодонтимформа", (float)988.0),
                Arguments.of(IngredientType.FILLING, "Хрустящие минеральные кольца", (float)300.0),
                Arguments.of(IngredientType.FILLING, "Плоды Фалленианского дерева", (float)874.0),
                Arguments.of(IngredientType.FILLING, "Кристаллы марсианских альфа-сахаридов", (float)762.0),
                Arguments.of(IngredientType.FILLING, "Мини-салат Экзо-Плантаго", (float)762.0),
                Arguments.of(IngredientType.FILLING, "Сыр с астероидной плесенью", (float)4142.0)
        );
    }
}