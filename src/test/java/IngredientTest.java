import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(JUnit4.class)
public class IngredientTest {
    Ingredient ingredient;
    IngredientType type=IngredientType.SAUCE;
    String name = "ketchup";
    float price = 150;
    @Before
    public void setUp(){
        ingredient = new Ingredient(type, name, price);
    }
   @Test
    public void getPriceTest(){
       Assert.assertEquals(price, ingredient.getPrice(), 0.01);
   }
    @Test
    public void getNameTest(){
        Assert.assertEquals(name, ingredient.getName());
    }
}
