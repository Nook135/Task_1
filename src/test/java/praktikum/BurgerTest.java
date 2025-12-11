package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bunMock;

    @Mock
    private Ingredient ingredientMock;

    @Mock
    private Ingredient anotherIngredientMock;

    @BeforeEach
    void setUp() {
        burger = new Burger();
    }

    // проверка что булочка установится в бургер
    @Test
    void setBunsShouldSetBun() {
        burger.setBuns(bunMock);
        assertSame(bunMock, burger.bun);
    }
    // проверка что добавится ингридиент
    @Test
    void addIngredientShouldAddToIngredients() {
        burger.addIngredient(ingredientMock);
        assertEquals(1, burger.ingredients.size());
        assertSame(ingredientMock, burger.ingredients.get(0));
    }

    // проверка что удалится ингридиент
    @Test
    void removeIngredientShouldRemoveFromList() {
        burger.addIngredient(ingredientMock);
        burger.addIngredient(anotherIngredientMock);

        burger.removeIngredient(0);

        assertEquals(1, burger.ingredients.size());
        assertSame(anotherIngredientMock, burger.ingredients.get(0));
    }

    // проверка что  ингридиент переместится на другую позицию
    @Test
    void moveIngredientShouldChangePosition() {
        burger.addIngredient(ingredientMock);
        burger.addIngredient(anotherIngredientMock);
        burger.moveIngredient(0, 1);
        assertEquals(2, burger.ingredients.size());
        assertSame(anotherIngredientMock, burger.ingredients.get(0));
        assertSame(ingredientMock, burger.ingredients.get(1));
    }

    // Проверка расчета общей цены
   @Test
    void getPriceShouldReturnSumOfBunAndIngredients() {
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        burger.addIngredient(anotherIngredientMock);

        when(bunMock.getPrice()).thenReturn((float)100.0);
        when(ingredientMock.getPrice()).thenReturn((float)50.0);
        when(anotherIngredientMock.getPrice()).thenReturn((float)30.0);

        float expectedPrice = 100.0f * (float) 2 + 50.0f + 30.0f;
        assertEquals(expectedPrice, burger.getPrice(), (float)0.001);
    }
    // цена бургера
    @Test
    void getPriceShouldWorkWithoutIngredients() {
        burger.setBuns(bunMock);
        when(bunMock.getPrice()).thenReturn((float)150.0);
        assertEquals((float)300.0, burger.getPrice(), (float)0.001);
    }


   @Test
    void getPriceShouldCallGetPriceOnBunAndIngredients() {
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        when(bunMock.getPrice()).thenReturn((float)100.0);
        when(ingredientMock.getPrice()).thenReturn((float)50.0);
        burger.getPrice();
        verify(bunMock, times(1)).getPrice();
        verify(ingredientMock, times(1)).getPrice();
    }

    @Test
    void getReceiptShouldCallGetNameAndGetType() {
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        when(bunMock.getName()).thenReturn("black bun");
        when(ingredientMock.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredientMock.getName()).thenReturn("hot sauce");
        burger.getReceipt();
        // проверяем, что методы были вызваны
        verify(bunMock, times(2)).getName(); // Два раза в чеке
        verify(ingredientMock, times(1)).getType();
        verify(ingredientMock, times(1)).getName();
    }
}