import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import praktikum.IngredientType;

@RunWith(JUnit4.class)
public class IngredientTypeTest {
    @Test
    public void testEnumToString() {
        Assert.assertEquals("SAUCE", IngredientType.SAUCE.toString());
        Assert.assertEquals("FILLING", IngredientType.FILLING.toString());
    }
    @Test
    public void testEnumValueOf() {
        Assert.assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        Assert.assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}
