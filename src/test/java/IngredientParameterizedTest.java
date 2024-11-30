import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {
    Ingredient ingredient;
    IngredientType type;
    String name = "ketchup";
    float price = 150;
    public IngredientParameterizedTest(IngredientType type){
        this.type=type;
        ingredient=new Ingredient(type, name, price);
    }
    @Test
    public void getTypeTest(){
        Assert.assertEquals(type, ingredient.getType());
    }
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {IngredientType.SAUCE}, {IngredientType.FILLING}
        });
    }
}
