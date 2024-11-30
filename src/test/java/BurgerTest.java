import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class BurgerTest {
    private Burger burger;
    @Mock
    private Bun testBun;
    @Mock
    private Ingredient testSauce;
    @Mock
    private Ingredient testFilling;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        burger = new Burger();
        burger.setBuns(testBun);
        when(testBun.getName()).thenReturn("Mock Bun");
        when(testBun.getPrice()).thenReturn(200F);
        when(testSauce.getType()).thenReturn(IngredientType.SAUCE);
        when(testSauce.getName()).thenReturn("Mock Sauce");
        when(testSauce.getPrice()).thenReturn(100F);
        when(testFilling.getType()).thenReturn(IngredientType.FILLING);
        when(testFilling.getName()).thenReturn("Mock Filling");
        when(testFilling.getPrice()).thenReturn(300F);
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(testBun);
        assertEquals(testBun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(testSauce);
        Assert.assertTrue(burger.ingredients.contains(testSauce));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(testFilling);
        burger.removeIngredient(burger.ingredients.size() - 1);
        Assert.assertFalse(burger.ingredients.contains(testFilling));
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(testSauce);
        burger.addIngredient(testFilling);
        burger.moveIngredient(0, 1);
        assertEquals(burger.ingredients.get(0), testFilling);
        assertEquals(burger.ingredients.get(1), testSauce);
    }

    @Test
    public void getPriceTest() {
        burger.addIngredient(testFilling);
        burger.addIngredient(testSauce);
        assertEquals(testBun.getPrice() * 2 + testFilling.getPrice() + testSauce.getPrice(), burger.getPrice(), 0.01);
    }

    @Test
    public void getReceiptTest() {
        burger.addIngredient(testSauce);
        burger.addIngredient(testFilling);

        String expectedReceipt = String.format("(==== %s ====)%n", testBun.getName()) +
                String.format("= %s %s =%n", testSauce.getType().toString().toLowerCase(), testSauce.getName()) +
                String.format("= %s %s =%n", testFilling.getType().toString().toLowerCase(), testFilling.getName()) +
                String.format("(==== %s ====)%n", testBun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
